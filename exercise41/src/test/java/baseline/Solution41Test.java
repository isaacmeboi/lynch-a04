package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    @Test
    //check to ensure the directory is correct
    void IONamesTest() throws FileNotFoundException {
        Solution41 ca = new Solution41();
        String userHomeDir = System.getProperty("user.home");
        String expected = userHomeDir+"\\Desktop\\exercise41_input.txt";
        String actual = ca.call();
        assertEquals(expected, actual);
    }
}