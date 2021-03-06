/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Isaac Lynch
 */
package baseline;

import java.util.*;
import java.io.*;

public class Solution42 {

    // Method to print the details in tabular format.
    // It takes the name of the filename as its parameter
    public void Details(String filename) throws IOException {
        try {
            String userHomeDir = System.getProperty("user.home");
            File file = new File(userHomeDir + "\\Desktop\\exercise42_input.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] temp = s.split(",");
                System.out.printf("%-17s%-17s%-17s%n", temp[0], temp[1], temp[2]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }
    public String Formatting() throws IOException {

        String userHomeDir = System.getProperty("user.home");
        String Dir = userHomeDir + "\\Desktop\\exercise42_input.txt";
        Solution42 emp = new Solution42();
        System.out.printf("%-17s%-17s%-17s%n", "Last", "First", "Salary");
        System.out.println("----------------------------------------");
        emp.Details(Dir);
        return Dir;
    }

    // Driver method to test the code
    public static void main(String[] args) throws IOException {
    Solution42 ca = new Solution42();
    ca.Formatting();
    }
}

