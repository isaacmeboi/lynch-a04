package baseline;

import java.io.*;
import java.util.*;

public class Solution41 {

    //readNames() function to read data from Scanner object to ArrayList
    public static void readNames(Scanner input, List<String> names) {
        // reading the data till nextLine
        while (input.hasNextLine()) {
            //adding read line to list of names
            names.add(input.nextLine());
        }
    }
    //function to print names in file
    public static void outputNames(List<String> names) throws IOException {
        //to ensure that directory is set to user's desktop
        String userHomeDir = System.getProperty("user.home");
        String Dir = userHomeDir + "\\Desktop\\exercise41_output.txt";
        FileWriter output = new FileWriter(Dir);
        //header for output file
        output.write("Total of " + names.size() + " names\n");
        output.write("--------------------\n");

        for (String i : names) {

            output.write(i + "\n");

        }
        //close FileWriter to avoid memory leakage
        output.close();
    }
    public String call() throws FileNotFoundException {

        String userHomeDir = System.getProperty("user.home");
        String Dir = userHomeDir + "\\Desktop\\exercise41_input.txt";
        Scanner inputFile = new Scanner(new File(Dir));
        ArrayList<String> names = new ArrayList<>();
        // reading the names from the input file
        readNames(inputFile, names);
        // sorting list of names
        names.sort(String.CASE_INSENSITIVE_ORDER);
        inputFile.close();
        return Dir;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Solution41 ca = new Solution41();
        ca.call();
        ArrayList<String> names = new ArrayList<>();
        // writing the data to output file
        try {
            outputNames(names);
        }
        //if any exception is raised in writing the output file this prints the exception on the console
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

