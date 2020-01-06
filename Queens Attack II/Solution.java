import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int reachableSquares = 0;
        //Finds the closest object in each direction
        //Row Column coordinates of the closes object in each direction
        int rRObstacle = -1;
        int cRObstacle = -1;
        int rBRObstacle = -1;
        int cBRObstacle = -1;
        int rBObstacle = -1;
        int cBObstacle = -1;
        int rBLObstacle = -1;
        int cBLObstacle = -1;
        int rLObstacle = -1;
        int cLObstacle = -1;
        int rTLObstacle = -1;
        int cTLObstacle = -1;
        int rTObstacle = -1;
        int cTObstacle = -1;
        int rTRObstacle = -1;
        int cTRObstacle = -1;
        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = obstacles[a0][0];
            int cObstacle = obstacles[a0][1];
            
            //Right
            if((cObstacle < cRObstacle || rRObstacle == -1) && cObstacle > cQueen && rObstacle == rQueen)
            {
                rRObstacle = rObstacle;
                cRObstacle = cObstacle;
            }
            
            //Bottom Right
            if(rQueen - rObstacle == cObstacle - cQueen && cObstacle > cQueen && rObstacle < rQueen 
               && ((rObstacle > rBRObstacle && cObstacle < cBRObstacle) || rBRObstacle == -1))
            {
                rBRObstacle = rObstacle;
                cBRObstacle = cObstacle;
            }
            
            //Bottom    
            if((rObstacle > rBObstacle || rBObstacle == -1) && rObstacle < rQueen && cObstacle == cQueen)
            {
                rBObstacle = rObstacle;
                cBObstacle = cObstacle;
            }
            
            //Bottom Left
            if(rQueen - rObstacle == cQueen - cObstacle && cObstacle < cQueen && rObstacle < rQueen 
               && ((rObstacle > rBLObstacle && cObstacle > cBLObstacle) || rBLObstacle == -1))
            {
                rBLObstacle = rObstacle;
                cBLObstacle = cObstacle;
            }
            
            //Left
            if((cObstacle > cLObstacle || rLObstacle == -1) && cObstacle < cQueen && rObstacle == rQueen)
            {
                rLObstacle = rObstacle;
                cLObstacle = cObstacle;
            }
            
            //Top Left
            if(cQueen - cObstacle == rObstacle - rQueen && cObstacle < cQueen && rObstacle > rQueen 
               && ((rObstacle < rTLObstacle && cObstacle > cTLObstacle) || rTLObstacle == -1))
            {
                rTLObstacle = rObstacle;
                cTLObstacle = cObstacle;
            }
            
            //Top
            if((rObstacle < rTObstacle || rTObstacle == -1) && rObstacle > rQueen && cObstacle == cQueen)
            {
                rTObstacle = rObstacle;
                cTObstacle = cObstacle;
            }
            
            //Top Right
            if(rObstacle - rQueen == cObstacle - cQueen && cObstacle > cQueen 
               && rObstacle > rQueen && ((rObstacle < rTRObstacle && cObstacle < cTRObstacle) || rTRObstacle == -1))
            {
                rTRObstacle = rObstacle;
                cTRObstacle = cObstacle;
            }
                           
        }
        
        //Calculates the distance to the closest obstacle in each direction and adds it to reachableSquares
        //R B L T
        reachableSquares += (cRObstacle != -1) ? (cRObstacle - cQueen -1) : n - cQueen;     
        reachableSquares += (rBObstacle != -1) ? (rQueen - rBObstacle - 1) : rQueen - 1;   
        reachableSquares += (cLObstacle != -1) ? (cQueen - cLObstacle -1) : cQueen - 1;  
        reachableSquares += (rTObstacle != -1) ? (rTObstacle - rQueen - 1) : n - rQueen;

        //BR BL TL TR
        reachableSquares += (cBRObstacle != -1) ? (cBRObstacle - cQueen -1) : Math.min(n - cQueen, rQueen - 1); 
        reachableSquares += (rBLObstacle != -1) ? (cQueen - cBLObstacle - 1) : Math.min(cQueen - 1, rQueen - 1); 
        reachableSquares += (cTLObstacle != -1) ? (cQueen - cTLObstacle -1) : Math.min(cQueen - 1, n - rQueen);  
        reachableSquares += (rTRObstacle != -1) ? (cTRObstacle - cQueen - 1) : Math.min(n - cQueen, n - rQueen); 
        return reachableSquares;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
