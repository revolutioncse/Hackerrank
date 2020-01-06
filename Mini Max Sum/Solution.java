import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

     // Complete the miniMaxSum function below.
     static void miniMaxSum(int[] arr) {
        long ar[] = new long[5];
        for(int i=0;i<5;i++)
        {
            long count = 0;
            for(int j=0;j<5;j++)
            {
                if(i==j){continue;}
                count = count+arr[j];
            }
            ar[i] = count;
        }
        Arrays.sort(ar);
        System.out.println(ar[0]+" "+ar[4]);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
