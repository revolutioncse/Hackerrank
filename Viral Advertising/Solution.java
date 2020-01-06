import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int liked=0;
int cummulative=0;
int shared = 5;
for(int i=0;i<n;i++)
{
    liked=(shared)/2;
    cummulative=cummulative +liked;
    shared = liked*3;
}
return cummulative;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);
        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
