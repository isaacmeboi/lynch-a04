/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Isaac Lynch
 */
package baseline;
import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Solution44 {

    public String parser() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        //read json file using parser & store it
        String userHomeDir = System.getProperty("user.home");
        String Dir = userHomeDir + "\\Desktop\\exercise44_input.json";
        Object obj = parser.parse(new FileReader(Dir));
        //reads internal values
        JSONObject jsonObject = (JSONObject) obj;
        //reads products
        JSONArray subjects = (JSONArray) jsonObject.get("products");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        //flag is used whether given string is present or not
        int flag = 0;
            try {

                System.out.print("What is the product name? ");
                input = bufferedReader.readLine();
                //loop thru the iterator
                for (Object subject : subjects) {

                    JSONObject json = (JSONObject) subject;
                    String name = (String) json.get("name");
                    //compares name with input
                    if (input.equalsIgnoreCase(name)) {
                        System.out.println("Name: " + name);
                        System.out.println("Price: " + json.get("price"));
                        System.out.println("Quantity: " + json.get("quantity"));
                        flag = 1;
                    }
                }
                //if zero, val. not found
                if (flag == 0) {
                    System.out.println("Sorry, that product was not found in our inventory");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Dir;
        }

        public static void main (String[]args) throws IOException, ParseException {
        Solution44 ca = new Solution44();
        ca.parser();

        }

}
