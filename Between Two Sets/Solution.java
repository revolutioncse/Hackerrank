import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    // Write your code here
    public static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            
            if (a >= b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }

        return a + b;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        
        int multiple = 0;
        for(int i : b) {
            multiple = gcd(multiple, i);
        }
//        System.err.println("Multiple: " + multiple);
        
        int factor = 1;
        for(int i : a) {
            factor = lcm(factor, i);
            if (factor > multiple) {
                return 0;
            }
        }

        if (multiple % factor != 0) {
            return 0;
        }
//        System.err.println("Factor: " + factor);
        
        int value = multiple / factor;
        
        int max = Math.max(factor, value);
        int totalX = 1;
        
        for (int i = factor; i < multiple; i++) {
            if (multiple % i == 0 && i % factor == 0) {
                totalX++;
            }
        }

        return totalX;
        
    }
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result.getTotalX(arr, brr);
        System.out.println(String.valueOf(total));
        // bufferedWriter.write(String.valueOf(total));
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
