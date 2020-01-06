import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        char c = 'a';
        //System.out.println(c+1);
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i:h)
        {
            hmap.put((int) c, i);
            c++;
        }
        char arr[] = word.toCharArray();
        int maxHeight = 0;
        for(char a:arr)
        {
            if(hmap.get((int)a)>maxHeight)
            {
                maxHeight=hmap.get((int)a);
            }
        }
        return maxHeight*word.length();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        System.out.println(result);

        scanner.close();
    }
}
