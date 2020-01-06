import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'IsBalancedString' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts STRING s as parameter.
     */

    public static boolean IsBalancedString(String s) {
        // char arr[] = s.toCharArray();
        int acCount = 0;
        int bdCount = 0;
        //int cCount = 0;
        //int dCount = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='c' )
            {
                acCount++;
            }
            if(s.charAt(i)=='b' || s.charAt(i)=='d' )
            {
                bdCount++;
            }
        }
        System.out.print(acCount+" "+bdCount);
        if(acCount%2==0 && bdCount%2==0)
        {
            return true;
        }
        else
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        boolean result = Result.IsBalancedString(s);

        bufferedWriter.write(String.valueOf(result ? 1 : 0));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
