import java.io.*; //IO functions

public class ParseLog {
	//This will be how logs are parsed into our program
	public static void main(String[] args) {
		for(int i=0;i<50;i++) parse();
	}

	//Setting up the File IO objects
	static File file = new File("/Users/justinlargent/Downloads/catalina.out");
	public static void parse() {
		String[] split = null;
		String log = null;
		//reading a line from the log
		try(InputStream fin = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fin))) {
			log = reader.readLine();
			//System.out.println(log);
		} catch (IOException ex) {
			System.err.println(ex);
		}

		//splitting the log message into parts
		split = log.split("[|]");
		System.out.println(split[0]);
		//Determine if it is a Warning, Info, or Error
		/*switch(split[0].charAt(0)) {
			case 'W':
				warn();
				break;
			case 'I':
				info();
				break;
			case 'E':
				error();
				break;
		}*/
	}

	public static void warn() {
		System.out.println("Warning");
	}

	public static void info() {
		System.out.println("Information");
	}

	public static void error() {
		System.out.println("Error");
	}
	
}
