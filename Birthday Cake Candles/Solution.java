import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int max = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int a: ar)
        {
            if(hmap.containsKey(a))
            {
                int v = hmap.get(a)+1;
                hmap.put(a, v);
            }
            else
            hmap.put(a,1);
        }
        Collection<Integer> valueList = hmap.values();
        Object arr[]=valueList.toArray();
        Arrays.sort(arr);
        return (int)arr[arr.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);
        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
