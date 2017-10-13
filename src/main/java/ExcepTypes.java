import java.util.LinkedList;

public class ExcepTypes {
    String nameOfExcep, dateAndTime;
    LinkedList<Excep> excepTypes = new LinkedList<Excep>();

    ExcepTypes() {
        excepTypes.add(new Excep("0000-00-00 00:00:00,000", "NewException"));
    }

    ExcepTypes(String dateAndTime, String nameOfExcep) {
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