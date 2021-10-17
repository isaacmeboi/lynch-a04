package baseline;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {
    //ensure that the directory is correct
    @Test
            void directoryTest() throws IOException {
        Solution42 ca = new Solution42();
        String userHomeDir = System.getProperty("user.home");
        String expected = userHomeDir+"\\Desktop\\exercise42_input.txt";
        String actual = ca.Formatting();
        assertEquals(expected, actual);
    }

}