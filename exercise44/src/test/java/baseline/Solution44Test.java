package baseline;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Solution44Test {
    @Test
    void directTest() throws IOException, ParseException {
        Solution44 ca = new Solution44();
        String userHomeDir = System.getProperty("user.home");
        String expected = userHomeDir + "\\Desktop\\exercise44_input.txt";
        String actual = ca.parser();
        assertEquals(expected, actual);
    }
}