import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static HashMap<String,Boolean> hmap = new HashMap();
    // Complete the chessboardGame function below.
    static boolean chessboardGame(int x, int y) {
        //int count =0;
        String cord = x+","+y;
        if(x<1 | y<1 | x>15 | y>15)
        {
            return true;
        }
        if(hmap.containsKey(cord))
        {
            //System.out.println(hmap.values());
            //System.out.println(hmap.get("1,1"));
            //boolean res = hmap.get(cord);
            //System.out.println(res);
            return hmap.get(cord);
        }
        
        boolean state =true;
        state = state & chessboardGame(x-1, y-2);
        //System.out.println(state);
        state = state & chessboardGame(x+1, y-2);
        state = state & chessboardGame(x-2, y+1);
        state = state & chessboardGame(x-2, y-1);
        hmap.put(cord, (state==false));
        return (state==false);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

            //String result = chessboardGame(x, y);
            boolean result = chessboardGame(x, y);
            if(result)
            System.out.println("First"); 
            else
            System.out.println("Second"); 

            //System.out.println(result);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
