import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String  ampm = s.substring(s.length()-2,s.length());
        if(ampm.equals("PM"))
        {
            if(s.substring(0, s.length()-2).equals("12:00:00"))
            {
                return "12:00:00";
            }
            int hour = Integer.parseInt(s.substring(0, 2))+12;
            if(hour != 24)
            return hour+s.substring(2, s.length()-2);
            return s.substring(0, s.length()-2);
        }
        else
        {
            if(s.substring(0, s.length()-2).equals("12:00:00"))
            {
                return "00:00:00";
            }
            int hour = Integer.parseInt(s.substring(0, 2));
            if(hour == 12)
            return "00"+s.substring(2, s.length()-2);
            return s.substring(0, s.length()-2);
        }
        //return ampm;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);
        //bw.write(result);
        //bw.newLine();

        //bw.close();
    }
}
