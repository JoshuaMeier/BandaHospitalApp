import java.util.ArrayList;

public class Times {
	
	ArrayList times = new ArrayList<>();
	
	public Times() {
		this.times.add(0);
	}
	
	public Times(double time) {
		if(times.size() <= 10) {
			this.times.add(time);
		}
		else {
			//CODE TO SEN EMAIL HERE!
		}
	}
}
