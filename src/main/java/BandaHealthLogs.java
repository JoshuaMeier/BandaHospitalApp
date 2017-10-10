//Driver class
import java.io.*;

public class BandaHealthLogs {
  public static void main(String[] args) {
    ExceptionType exceptionList = new ExceptionType();

    String log = null;
		//reading a line from the log
    File file = new File("./catalina.out");
		try(InputStream fin = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fin))) {
			for(int i=0;i<100;i++) {
				log = reader.readLine();
				ParseLog.parse(log, exceptionList);
			}
			//System.out.println(log);
		} catch (IOException ex) {
			System.err.println(ex);
		}
  }
}
