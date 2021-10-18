/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Isaac Lynch
 */
package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution46 {
    public static void main(String[] args) throws FileNotFoundException {


        ReadInputFile rf = new ReadInputFile();
        //read file
        rf.readfile();
        //get map
        HashMap<String, Integer> map = rf.getMap();
        PrintReport pr = new PrintReport(map);
        //print it on screen
        pr.printScreen();

    }

}

class ReadInputFile{

    private Scanner sc;
    private File file;
    private HashMap<String, Integer> map;
    String userHomeDir = System.getProperty("user.home");

    public  ReadInputFile() throws FileNotFoundException {
        File file = new File( userHomeDir+"\\Desktop\\exercise46_input.txt");
        sc = new Scanner(file);
        map = new HashMap<>();

    }

    public void readfile() {

        //use try and finally to avoid exceptions
        try
        {

            while( sc.hasNext() )
            {
                String input = sc.nextLine();
                // split it by spaces
                String[] arr = input.split(" ");
                for (String key : arr) {
                    // if key is already in map then
                    if (map.containsKey(key)) {
                        // update value by 1
                        int value = map.get(key);
                        value++;
                        map.put(key, value);
                    }
                    // else put it in the map
                    else {

                        map.put(key, 1);

                    }

                }


            }
        }
        finally
        {
            sc.close();
        }

    }

//method for return map

    public HashMap<String, Integer> getMap(){

        return map;

    }

    public String getUserHomeDir() {
        String Dir = userHomeDir+"\\Desktop\\exercise46_input.txt";
        return Dir;
    }
}

record PrintReport(HashMap<String, Integer> map) {

    //prints histogram on screen
    public void printScreen() {

        String[] keys = new String[map.size()];
        Integer[] values = new Integer[map.size()];

        int k = 0;
        //iterate map and store array

        for (Entry<String, Integer> entry : map.entrySet()) {

            keys[k] = entry.getKey();
            values[k++] = entry.getValue();

        }

        int[] tempvalues = new int[map.size()];
        String[] tempkeys = new String[map.size()];

        // duplicate values arrays to tempvalues
        for (int i = 0; i < values.length; i++) {

            tempvalues[i] = values[i];

        }

        //reverse sort values array
        Arrays.sort(values, Collections.reverseOrder());

        //sort keys array according to values array
        for (int i = 0; i < map.size(); i++) {

            int value = values[i];

            for (int j = 0; j < tempvalues.length; j++) {

                if (value == tempvalues[j]) {

                    tempkeys[i] = keys[j];

                    break;

                }

            }

        }

        System.out.println();

        //print histogram

        for (int i = 0; i < map.size(); i++) {

            int value = map.get(tempkeys[i]);
            System.out.print(tempkeys[i] + " : \t");


            for (int j = 0; j < value; j++) {

                System.out.print("*");

            }

            System.out.println();

        }


    }


}
