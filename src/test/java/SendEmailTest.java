import com.icegreen.greenmail.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class SendEmailTest {

    private static final int SMTP_TEST_PORT = 3024;
    private GreenMail greenMail;
    private SendEmail mailSender;

    @Before
    public void setUp() throws Exception {
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
        mailSender = new SendEmail();
    }

    @After
    public void tearDown() throws Exception {
        greenMail.stop();
    }

    @Test
    public void send() throws Exception {
        mailSender.send("testSender@gmail.com", "testReceive@gmail.com",
                "testMessage","ERROR - errorhandler_jsp._jspService(159)", "localhost", SMTP_TEST_PORT);
        assertThat(greenMail.getReceivedMessages()[0].getContent(), equalTo("testMessage\r\n"));
    }
}