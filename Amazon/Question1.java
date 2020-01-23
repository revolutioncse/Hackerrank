// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int numberAmazonGoStores(int rows, int column, List<List<Integer> > grid)
    {
        // WRITE YOUR CODE HERE
   
    int[][] array = new int[grid.size()][];
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[grid.get(i).size()];
		}
		for(int i=0; i<grid.size(); i++){
			for (int j = 0; j < grid.get(i).size(); j++) {
				array[i][j] = grid.get(i).get(j);
			}
		}

if (array == null || array.length == 0) return 0;
		int result = 0;
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				if (array[i][j] == 1) {
					result++;
					doFill(array, i, j);
				}
			}
		}
		return result;
    }
    // METHOD SIGNATURE ENDS
    public static void doFill(int[][] matrix, int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >=matrix[0].length || matrix[row][col] == 0) {
			return;
		}
		matrix[row][col] = 0;
		int dr[] = {-1,0,1,0};
		int dc[] = {0,1,0,-1};
		for (int i=0; i<dr.length; i++) {
			doFill(matrix, row + dr[i], col + dc[i]);
		}
	}
    
}