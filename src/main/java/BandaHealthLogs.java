
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

public class BandaHealthLogs extends Thread {

  static LinkedHashMap<String, ArrayList<Excep>> excepTypes = new LinkedHashMap<>();

  public static void main(String[] args) throws InterruptedException {
      ExecutorService executor = Executors.newFixedThreadPool(1);
      Config config = new Config();
      Path dir = FileSystems.getDefault().getPath(config.getProperty("logPath"));
      WatchKey key;
      WatchService watcher = null;

          try {
              watcher = FileSystems.getDefault().newWatchService();
              while(true) {
                  key = dir.register(watcher, ENTRY_MODIFY);

                  Thread.sleep(50);

                  for (WatchEvent<?> event : key.pollEvents()) {
                      WatchEvent.Kind<?> kind = event.kind();
                      WatchEvent<Path> path = (WatchEvent<Path>) event;
                      Path filename = path.context();
                      if (kind == OVERFLOW) {
                          continue;
                      }

                      if (kind == ENTRY_MODIFY) {
                          if (filename.toString().equals(config.getProperty("fileName"))) {
                              executor.execute(new BandaHealthLogs());
                          }
                      }
                  }

                  key.reset();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }

      }

  public void run() {
      ParseLog parse = new ParseLog();
      parse.readLog();
  }
}
