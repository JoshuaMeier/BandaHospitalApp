import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

public class BandaHealthLogs extends Thread {

    static Path dir = FileSystems.getDefault().getPath("D:\\Users\\jmbla.DESKTOP-L5RS36I\\Documents");
  static LinkedHashMap<String, ArrayList<Excep>> excepTypes = new LinkedHashMap<>();
  static boolean stop = false;

  public static void main(String[] args) throws InterruptedException {
      ExecutorService executor = Executors.newFixedThreadPool(1);

      while(true) {
          WatchService watcher = null;
          try {
              watcher = FileSystems.getDefault().newWatchService();
          } catch (IOException e) {
              e.printStackTrace();
          }
          while(!stop) {
              WatchKey key;
              try {
                  key = dir.register(watcher, ENTRY_MODIFY);

                  for(WatchEvent<?> event: key.pollEvents()) {
                      WatchEvent.Kind<?> kind = event.kind();
                      WatchEvent<Path> path = (WatchEvent<Path>)event;
                      Path filename = path.context();
                      if(kind == OVERFLOW) {
                          continue;
                      }

                      if(kind == ENTRY_MODIFY) {
                          if(filename.toString().equals("catalina.out")) {
                              executor.execute(new BandaHealthLogs());
                              stop = true;
                          }
                      }
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }

      }

  }

  public void run() {
      ParseLog.readLog(dir);
  }
}
