package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class Solution46Test {


    @Test
        //once again, ensuring that the directory of the user is correct
    void test() throws FileNotFoundException {
        ReadInputFile ca = new ReadInputFile();
        String userHomeDir = System.getProperty("user.home");
        String expected = userHomeDir+"\\Desktop\\exercise46_input.txt";
        String actual =  ca.getUserHomeDir();
        assertEquals(expected,actual);
    }


}