import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.icegreen.greenmail.util.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class SendEmailTest {

    private static final int SMTP_TEST_PORT = 3025;
    private GreenMail greenMail;
    private SendEmail mailSender;

    @Before
    public void setUp() throws Exception {
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
        mailSender = new SendEmail("localhost", SMTP_TEST_PORT);
    }

    @After
    public void tearDown() throws Exception {
        greenMail.stop();
    }

    @Test
    public void send() throws Exception {
        mailSender.send("testSender@gmail.com", "testReceive@gmail.com",
                "testMessage","ERROR - errorhandler_jsp._jspService(159)");
        assertThat(greenMail.getReceivedMessages()[0].getContent(), equalTo("testMessage\r\n"));
    }
}