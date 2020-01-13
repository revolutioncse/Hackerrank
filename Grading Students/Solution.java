import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
            List<Integer> result = new ArrayList<>();
            for (Integer grade : grades) {
                if(grade<40 && grade>37)
                {
                    result.add(40);
                }
                else if(grade<37)
                {
                    result.add(grade);
                }
                else if(((grade-grade%5+5)-grade)<3)
                {
                    result.add(grade-grade%5+5);
                }
                else
                {
                    result.add(grade);
                }
            }
            return result;
        }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesCount; i++) {
            int gradesItem = Integer.parseInt(bufferedReader.readLine().trim());
            grades.add(gradesItem);
        }

        List<Integer> result = Result.gradingStudents(grades);

        for (int i = 0; i < result.size(); i++) {
            //bufferedWriter.write(String.valueOf(result.get(i)));
            System.out.println(String.valueOf(result.get(i)));
            // if (i != result.size() - 1) {
            //     bufferedWriter.write("\n");
            // }
        }

        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
