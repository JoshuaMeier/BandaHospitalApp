import java.util.LinkedList;

/*
This is the head linkedlist to the data structure. It creates a list of type
Excep called excepTypes and adds the name of the exception and the date and
time the exception was called to the linked list.
 */
public class ExcepTypes {
    String nameOfExcep, dateAndTime;
    LinkedList<Excep> excepTypes = new LinkedList<Excep>();

    ExcepTypes() {
        excepTypes.add(new Excep("0000-00-00 00:00:00,000", "NewException"));
    }

    ExcepTypes(String dateAndTime, String nameOfExcep) {
        excepTypes.add(new Excep(dateAndTime, nameOfExcep));
    }

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

/*
What do I want the program to call?

system.out.println();

 */