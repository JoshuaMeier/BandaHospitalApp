import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class ParseLog {
	//This will be how logs are parsed into our program

	public  void readLog () {

		InputStream fin = null;
		BufferedReader reader = null;
		StringBuilder builder;
		File file;
		String log;
		String[] split;
		String temp;
        String excepName;
        String excepTime;
		Config config = new Config();

		Path dir = FileSystems.getDefault().getPath(config.getProperty("logPath"));

		try {

			file = new File(dir.toString() + "/" + config.getProperty("fileName"));
			fin = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(fin));

			log = reader.readLine();
			builder = new StringBuilder(log);
            split = log.split("[|]");
            if(log.matches(".\\|.\\|.")) {
				excepName = split[0];
				excepTime = split[1];
			} else {
                excepName = log;
                split = log.split("[:]");
                excepTime = split[0] + split[1];
            }
            switch(excepName.charAt(0)) {
                case 'W':
                    if(config.getProperty("Warning").equals("true"))
                    //warn();
                    break;
                case 'I':
                    if(config.getProperty("Information").equals("true"))
                   // info();
                    break;
                case 'E':
                	if(!(BandaHealthLogs.excepTypes.containsKey(excepName))) {
						BandaHealthLogs.excepTypes.put(excepName, new ArrayList<>());
						while (true) {

							temp = reader.readLine();
							if (!(temp.matches("^WARN.*") || temp.matches("^INFO.*") || temp.matches("^ERROR.*"))) {
								builder.append(temp + "\n");
							} else {
								break;
							}
						}
						BandaHealthLogs.excepTypes.get(excepName).add(new Excep());
						BandaHealthLogs.excepTypes.get(excepName).get(BandaHealthLogs.excepTypes.get(excepName).size()-1).add(excepTime, builder.toString());
                        SendEmail.send(builder.toString(), excepName + excepTime);
					} else {
                	    //only storing the message on the first occurrence
                		BandaHealthLogs.excepTypes.get(excepName).get(BandaHealthLogs.excepTypes.get(excepName).size()-1).add(excepTime, null);
                        SendEmail.send(builder.toString(), excepName + excepTime);
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
}
