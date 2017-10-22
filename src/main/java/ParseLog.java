public class ParseLog {
	//This will be how logs are parsed into our program
	String[] split = null;
	ExcepTypes exceptions = null;
	private String log;
	public ParseLog(String log, ExcepTypes exceptions) {
	    this.log = log;
	    this.exceptions = exceptions;
    }
    public ParseLog(ExcepTypes exceptions) {
	    this.exceptions = exceptions;
    }
	public void parse() {
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
    public void parse(String log) {
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

	public void warn() {
		System.out.println("Warning");
	}

	public void info() {
		System.out.println("Information");
	}

	public void error(String[] split) {
		exceptions.add(split[1], split[0]);
		System.out.println("Error");
	}

}
