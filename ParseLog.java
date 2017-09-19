import java.io.*; //IO functions

public class ParseLog {
	//This will be how logs are parsed into our program
	public static void main(String[] args) {

		String log = null;
		//reading a line from the log
		try(InputStream fin = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fin))) {
			for(int i=0;i<100;i++) {
				log = reader.readLine();
				parse(log);
			}
			//System.out.println(log);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	//Setting up the File IO objects
	static File file = new File("/Users/justinlargent/Downloads/catalina.out");
	public static void parse(String log) {
		String[] split = null;

		//splitting the log message into parts
		split = log.split("[|]");
		//System.out.println(split[1]);
		//Determine if it is a Warning, Info, or Error
		switch(split[0].charAt(0)) {
			case 'W':
				warn();
				break;
			case 'I':
				info();
				break;
			case 'E':
				error(split);
				break;
		}
	}

	public static void warn() {
		System.out.println("Warning");
	}

	public static void info() {
		System.out.println("Information");
	}

	public static void error(String[] split) {
		String subject = split[0] + split[1];
		SendEmail.send(split[2], subject);
		System.out.println("Error");
	}

}
