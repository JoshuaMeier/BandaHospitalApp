import org.apache.commons.io.input.ReversedLinesFileReader;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class ParseLog {
	//This will be how logs are parsed into our program

	public  void readLog () {

		InputStream fin = null;
		ReversedLinesFileReader reader = null;
		StringBuilder builder = new StringBuilder();
		File file;
		String log;
		String[] split;
        StringBuilder excepName = new StringBuilder();
        StringBuilder excepTime = new StringBuilder();
		Config config = new Config();

		Path dir = FileSystems.getDefault().getPath(config.getProperty("logPath"));

		try {

			file = new File(dir.toString() + "/" + config.getProperty("fileName"));
			fin = new FileInputStream(file);
			reader = new ReversedLinesFileReader(file);

            builder = getLogMessage(builder, reader, excepName, excepTime);
            switch(excepName.toString().charAt(0)) {
                case 'W':
                    if(config.getProperty("Warning").equals("true"))
                        SendEmail.send(builder.toString(), excepName.toString() + excepTime.toString());
                    break;
                case 'I':
                    if(config.getProperty("Information").equals("true"))
                        SendEmail.send(builder.toString(), excepName.toString() + excepTime.toString());
                    break;
                case 'E':
                    if (!(BandaHealthLogs.excepTypes.containsKey(excepName.toString()))) {
                        BandaHealthLogs.excepTypes.put(excepName.toString(), new ArrayList<>());
                        BandaHealthLogs.excepTypes.get(excepName.toString()).add(new Excep());
                        BandaHealthLogs.excepTypes.get(excepName.toString()).get(BandaHealthLogs.excepTypes.get(excepName.toString()).size() - 1).add(excepTime.toString(), builder.toString());
                        SendEmail.send(builder.toString(), excepName.toString() + excepTime.toString());
                    } else {
                        //only storing the message on the first occurrence
                        BandaHealthLogs.excepTypes.get(excepName.toString()).get(BandaHealthLogs.excepTypes.get(excepName.toString()).size() - 1).add(excepTime.toString(), null);
                        SendEmail.send(builder.toString(), excepName.toString() + excepTime.toString());
                    }
            }
			fin.close();
            reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println();
		}
	}

	private StringBuilder getLogMessage(StringBuilder builder, ReversedLinesFileReader reader, StringBuilder excepName, StringBuilder excepTime) {
	    String temp;
	    String log;
	    String[] split;
	    ArrayList<String> tempLog = new ArrayList<>();

	    try {

            while (true) {

                temp = reader.readLine();
                if (!(temp.matches("^WARN.*") || temp.matches("^INFO.*") || temp.matches("^ERROR.*"))) {
                    tempLog.add(temp + "\n");
                } else {
                    tempLog.add(temp + "\n");
                    split = temp.split("[|]");
                    if(temp.matches(".*\\|.*")) {
                        excepName = excepName.append(split[0]);
                        excepTime = excepTime.append(split[1]);
                    } else {
                        excepName = excepName.append(temp);
                        split = temp.split("[:]");
                        excepTime = excepTime.append(split[0] + split[1]);
                    }
                    break;
                }
            }
            if(tempLog.size() == 1)
                builder.append(tempLog.get(0));
            else {
                for (int i = tempLog.size()-1; i > 0; i--) {
                    builder.append(tempLog.get(i));
                }
            }

        } catch (IOException e) {
	        System.err.println();
        }

        return builder;
    }
}
