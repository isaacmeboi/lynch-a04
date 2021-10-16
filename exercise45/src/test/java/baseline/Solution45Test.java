package baseline;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution45Test {
            @Test
            void ReadFileTest() throws FileNotFoundException {
                //ensure that the file is being read in the right location
                ReadFile ca = new ReadFile();
                String userHomeDir = System.getProperty("user.home");
                String expected = userHomeDir+"\\Desktop\\exercise44_input.txt";
                String actual = ca.directory();
                assertEquals(expected, actual);
        }
    @Test
    void WriteFileTest() throws IOException {
        //ensure that the file is being created in the right location
        ReadFile ca = new ReadFile();
        String userHomeDir = System.getProperty("user.home");
        String expected = userHomeDir+"\\Desktop\\"+ca.getName();
        String actual = ca.directoryDos();
        assertEquals(expected, actual);
    }

    }
