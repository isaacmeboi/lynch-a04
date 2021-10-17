package baseline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class generator {

    //strings set by user
    String siteName;
    String author;
    String path;

    //create web folder
    public String createWeb() {

//set directory
        String directory = path + siteName;
        File newFolder = new File(directory);

//create folder and return directory
        newFolder.mkdirs();
        return directory;


    }

    //creat JS folder
    public String createJS() {

//set directory
        String directory = path + siteName + "/js";
        File newFolder = new File(directory);

//return directory of new folder
        newFolder.mkdirs();
        return directory;


    }

    //create CSS folder
    public String createCSS() {

        String directory = path + siteName + "/css";
        File newFolder = new File(directory);

        newFolder.mkdirs();
        return directory;

    }

    //create HTML file
    public String createHTMl() {

//establish path
        String directory = path + siteName + "/index.html";

//create what goes inside the file
        String htmlContent = "<title> " + siteName + " </title>\n<meta> " + author + " </meta>";

//create file
        File file = new File(directory);

        try {

//write on file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(htmlContent);
            writer.close();
            return directory;

//exit if exceptions are found
        } catch(Exception ex) {

            return "Failure";
        }

    }

}


public class Solution43 {

    public static void main(String[] args) {

        Scanner newScan = new Scanner(System.in);

        String siteName;
        String author;
        String wantCSS;
        String wantJS;

        System.out.print("Site name: ");
        siteName = newScan.nextLine();
        System.out.print("Author: ");
        author = newScan.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        wantJS = newScan.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        wantCSS = newScan.nextLine();

        generator newWebsite = new generator();

//set the attributes for website
        newWebsite.siteName = siteName;
        newWebsite.author = author;
        newWebsite.path = "src/main/java/ex43/";

//create website and HTML file
        System.out.println("Created " + newWebsite.createWeb());
        System.out.println("Created " + newWebsite.createHTMl());


//print if user wants to create JS and CSS folder
        if(wantJS.equals("y"))
            System.out.println("Created " + newWebsite.createJS());

        if(wantCSS.equals("y"))
            System.out.println("Created " + newWebsite.createCSS());

    }

}