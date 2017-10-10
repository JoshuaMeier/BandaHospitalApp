import java.util.ArrayList;

public class Times {

	ArrayList times = new ArrayList<>();

	public Times() {
		this.times.add(0);
	}

	public Times(double time) {
			String subject = ParseLog.split[0] + ParseLog.split[1];
			SendEmail.send(ParseLog.split[2], subject);
		}
	}
