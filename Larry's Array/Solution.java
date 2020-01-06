import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {
        int sortedArray[] = A;
        Arrays.sort(sortedArray);
        int matchedIndex = 0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]!=sortedArray[i])
            {
                int count =0;
                while(count<3)
                {
                    rotate(A, i);
                    count++;
                    if(A[i]==sortedArray[i])
                    break;
                }
                if(count>=3)
                {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    static void rotate(int A[], int i)
    {
                int temp = A[i+2];
                A[i+2]=A[i];
                A[i]=temp;
                temp = A[i+2];
                A[i+2] = A[i+1];
                A[i+1] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            String result = larrysArray(A);

            // bufferedWriter.write(result);
            // bufferedWriter.newLine();
            System.out.println(result);
            System.out.println("");
        }

        // bufferedWriter.close();

        scanner.close();
    }
}
