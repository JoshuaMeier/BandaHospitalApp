import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParseLogTest {

    ExceptionType exceptionList = new ExceptionType();
    String string = "test|string";
    ParseLog parser = new ParseLog(string, exceptionList);
    @Test
    public void parse() throws Exception {
        parser.parse();
        assertArrayEquals(string.split("[|]"), parser.split);
    }

    @Test
    public void error() throws Exception {
        parser.error(string.split("[|]"));
        assertEquals(exceptionList, parser.exceptions);
    }

}