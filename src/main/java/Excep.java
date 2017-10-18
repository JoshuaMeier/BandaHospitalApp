import java.util.LinkedList;

/**
 * This is the lower level class for the Banda hospital app data structure.
 *      It has a lower level LinkedList that holds its data. Its also carries
 *      the name of the Exception.
 */
public class Excep extends LinkedList{
    String nameOfExcep, dateAndTime;

    LinkedList times = new LinkedList<String>();

    /**
     *
     */
    Excep() {
        nameOfExcep = "NewException";
        times.add("0000-00-00 00:00:00,000");
    }

    /**
     *
     * @param dateAndTime
     * @param nameOfExcep
     */
    Excep(String dateAndTime, String nameOfExcep) {
        this.nameOfExcep = nameOfExcep;
        times.add(dateAndTime);
    }

    public String getNameOfExcep() {
        return nameOfExcep;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public LinkedList getTimes() {
        return times;
    }

    public void setNameOfExcep(String nameOfExcep) {
        this.nameOfExcep = nameOfExcep;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setTimes(LinkedList times) {
        this.times = times;
    }
}
