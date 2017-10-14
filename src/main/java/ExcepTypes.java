import java.util.LinkedList;

/**
 * This is the head linkedlist to the data structure. It creates a list of typy
 * Excep called excepTypes and adds the name of the exception and the date and
 * time the exception was called to the linked list.
 *
 */
public class ExcepTypes {
    String nameOfExcep, dateAndTime;
    LinkedList<Excep> excepTypes = new LinkedList<Excep>();

    /**
     * This is a noargs-constructor ExcepType it is the catch all contructor that
     *      if called acidentally it will no break the code. intead it will set
     *      defaults to "0000-00-00 00:00:00,000" and "NewException"
     * @return nothing
     * @peram nothing
     */
    ExcepTypes() {
        excepTypes.add(new Excep("0000-00-00 00:00:00,000", "NewException"));
    }

    /**
     * This is the constructor for ExcepType it is the construtor that should be
     *      used for most of the static calling. it sends the data to its Excep
     *      Nodal class.
     * @param dateAndTime
     * @param nameOfExcep
     */
    ExcepTypes(String dateAndTime, String nameOfExcep) {
        excepTypes.add(new Excep(dateAndTime, nameOfExcep));
    }

    /**
     * This method does the heavy lifting of the code it is should be called the most often
     *      as it passes the dateandtime and the nameofexcep to the lower nodal class.
     * @param dateAndTime
     * @param nameOfExcep
     */
    public void add(String dateAndTime, String nameOfExcep) {
        excepTypes.add(new Excep(dateAndTime, nameOfExcep));
    }

    public String getNameOfExcep() {

        return nameOfExcep;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setNameOfExcep(String nameOfExcep) {
        this.nameOfExcep = nameOfExcep;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }


}

