import java.util.LinkedList;



/**
 * This is the lower level class for the Banda hospital app data structure.
 *      It has a lower level LinkedList that holds its data. Its also carries
 *      the name of the Exception.
 */
public class Excep extends LinkedList{

    String nameOfExcep, dateAndTime, errorMessage;

    LinkedList times = new LinkedList<String>();

    /**
     *
     */
    Excep() { }

    /**
     *
     * @param dateAndTime
     * @param nameOfExcep
     */
    Excep(String dateAndTime, String nameOfExcep, String errorMessage) {
        this.nameOfExcep = nameOfExcep;
        this.errorMessage = errorMessage;
        times.add(dateAndTime);
    }

    public add(String dateAndTime, String nameOfExcep, String errorMessage) {
        this.nameOfExcep = nameOfExcep;
        this.errorMessage = errorMessage;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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
