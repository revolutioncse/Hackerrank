import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char characters[] = w.toCharArray();

        return "no answer";
    }
    static void permute(String s, int l, int r)
    {
    //    TreeSet<String> result = new TreeSet<String>();
        if(l==r)
        {
            System.out.println(s);
        }
        for(int i=l;i<=r;i++)
        {
            permute(s, i, r);
        }
        
    }
    public String swap(String a, int i, int j)
    {
        char temp;
        char arr[] = a.toCharArray();
        temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
        return arr.toString();
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            // bufferedWriter.write(result);
            // bufferedWriter.newLine();
            System.out.println(result);
            System.out.println("");
        }

        // bufferedWriter.close();

        scanner.close();
    }
}
