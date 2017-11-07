
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExcepTest {

    Excep excep1 = new Excep();
    protected String time = "timeTest";
    protected String message = "messageTest";
    Excep excep2 = new Excep("timeTest", "messageTest");

    @Test
    public void add() throws Exception {
        excep1.add(time, message);
        assertEquals(excep1.message, excep2.message);
        assertEquals(excep1.time, excep2.time);
    }
}
