package Encryption;

import java.io.*;
import java.util.*;


public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        double length = Math.sqrt(s.length());
        double ceiling = Math.ceil(length);
        double floor = Math.floor(length);
        System.out.println(floor+"-----"+ceiling);
        String encrString ="";
        
            System.out.println("Here");
            for(int i=0;i<ceiling;i++)
            {
                int index=0;
                while((i+index)<s.length())
                {
                    encrString=encrString+s.charAt(i+index);
                    index=index+(int)ceiling;
                }
                encrString=encrString+" ";
            }
            return encrString;
        
       
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);
        System.out.println(result);
        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
