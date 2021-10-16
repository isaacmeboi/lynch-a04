package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution45 {
    // main method that throws IOException

    public static void main(String[] args) throws IOException {

        // create an object of Scanner class

        Scanner s = new Scanner(System.in);

        // prompt the name of output file from user

        System.out.print("\nEnter the output file : ");

        String output = s.next();

        // create an object of ReadFile class

        ReadFile rf = new ReadFile();

        // read file

        rf.read();

        // get the list contains data of file

        List<String> list = rf.getdata();

        // create an object of WriteFile
//       and passing output file name and list contains data

        WriteFile wr = new WriteFile(output, list);

        // write file

        wr.writefile();

        // and print the Number of Modifications on console

        System.out.println("\nThe Number of Modifications are : "+wr.getModification());


    }


}

class ReadFile{

    // instance variable

    private ArrayList<String> list;
    private Scanner sc;

    // constructor

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

    //return the list

    public List<String> getdata() {

        return list;

    }

}
class WriteFile{

    // instance variable

    private FileWriter writer;
    private int countModification;
    private List<String> list;

    // constructor

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

            // count the modifications

            while (true) {
                index = temp.indexOf(str, index);
                if (index != -1) {
                    countModification++;
                    index += str.length();
                } else {
                    break;
                }
            }

            // modification

            temp = temp.replace("utilize", "use");

            // and write into file

            writer.write(temp + "\n");


        }

        // close the writer object

        writer.close();

    }


    // method that returns the count of modifications

    public int getModification() {

        return countModification;

    }


}