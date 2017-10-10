import java.io.*; //IO functions

public class ParseLog {
	//This will be how logs are parsed into our program
	static String[] split = null;
	public static void parse(String log, ExceptionType exceptionList) {


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
				error(split, exceptionList);
				break;
		}
	}

	public static void warn() {
		System.out.println("Warning");
	}

	public static void info() {
		System.out.println("Information");
	}

	public static void error(String[] split, ExceptionType exceptionList) {
		exceptionList.addFirst(split[0], new Times(0));
		System.out.println("Error");
	}

}
