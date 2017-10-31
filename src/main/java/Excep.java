
public class Excep {
    String time;
    String message;

    Excep() {

    }

    public void add(String time, String message) {
        this.time = time;
        this.message = message;
    }

    public String toStringer() {
        return "{" + time + ", " + message + "}";
    }
}

