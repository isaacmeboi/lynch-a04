/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Isaac Lynch
 */
package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution45 {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        System.out.print("\nEnter the output file : ");
        String output = s.next();
        ReadFile rf = new ReadFile();
        rf.read();
        List<String> list = rf.getdata();

        // create an object of WriteFile and pass output file name and list contains data

        WriteFile wr = new WriteFile(output, list);
        wr.writefile();
        System.out.println("\nThe Number of Modifications are : "+wr.getModification());
    }
}

class ReadFile{
    // instance variable
    private ArrayList<String> list;
    private Scanner sc;

    public ReadFile() throws FileNotFoundException {

        list = new ArrayList<>();
        // initialize instance variable
        String userHomeDir = System.getProperty("user.home");
        // pass the path to the file as a parameter
        File file = new File(userHomeDir + "\\Desktop\\exercise44_input.txt");
        sc = new Scanner(file);

    }
    //this section is primarily for testing purposes to ensure that the directories are correct when read and
    //writing the files
    String name = "output.txt";

    public String getName() {
        name = "output.txt";
        return name;
    }
    public String directory(){
        String userHomeDir = System.getProperty("user.home");
        return userHomeDir+"\\Desktop\\exercise44_input.txt";
    }
    public String directoryDos(){
        String userHomeDir = System.getProperty("user.home");
        return userHomeDir+"\\Desktop\\"+name;
    }
    public void read() {

        // use try and finally to avoid exceptions

        try
        {
            int i=0;
            while( sc.hasNext() )
            {
                // read file line by line and store it into list
                String filedata = sc.nextLine();
                list.add(filedata);


            }
        }
        finally
        {
            sc.close();
        }

    }

    //return list

    public List<String> getdata() {

        return list;

    }

}
class WriteFile{

    private FileWriter writer;
    private int countModification;
    private List<String> list;

    public WriteFile(String name, List<String> list) throws IOException {

        // initialize variables
        String userHomeDir = System.getProperty("user.home");
        writer = new FileWriter(userHomeDir+"\\Desktop\\"+name);
        this.list = list;


    }
    // write into file

    public void writefile() throws IOException {

        // using for loop till size of list

        for (String temp : list) {

            String str = "utilize";

            int index = 0;

            // count the mods

            while (true) {
                index = temp.indexOf(str, index);
                if (index != -1) {
                    countModification++;
                    index += str.length();
                } else {
                    break;
                }
            }
            // mods
            temp = temp.replace("utilize", "use");
            writer.write(temp + "\n");


        }

        writer.close();

    }


    // method that returns count of mods

    public int getModification() {

        return countModification;

    }


}