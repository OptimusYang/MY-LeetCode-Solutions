package tim.d2015092201.spiralmatrix2;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
	https://leetcode.com/problems/spiral-matrix-ii/
 * @author Tim
 *
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        if(n==0){
           return new int[][]{};
        }
        int[][] matrix = new int[n][n];
		// right:1 down:2 left:3 up:4
		int direction = 1;
		int i = 0;
		int j = 0;
		matrix[i][j] = 1;
		for (int x = 2; x <= n * n; x++) {
			switch (direction) {
			case 1:
				if (j + 1 > n - 1 || matrix[i][j + 1] != 0) {
					direction = turnDirection(direction);
				} else {
					j++;
					matrix[i][j] = x;
					break;
				}
			case 2:
				if (i + 1 > n - 1 || matrix[i + 1][j] != 0) {
					direction = turnDirection(direction);
				} else {
					i++;
					matrix[i][j] = x;
					break;
				}
			case 3:
				if (j - 1 < 0 || matrix[i][j - 1] != 0) {
					direction = turnDirection(direction);
				} else {
					j--;
					matrix[i][j] = x;
					break;
				}
			case 4:
				if (i - 1 < 0 || matrix[i - 1][j] != 0) {
					direction = turnDirection(direction);
					j++;
					matrix[i][j] = x;
					break;
				} else {
					i--;
					matrix[i][j] = x;
					break;
				}
			}

		}
		return matrix;
    }
    public static int turnDirection(int direction) {
		int newDirection;
		// turn direction
		if (direction + 1 > 4) {
			newDirection = 1;
		} else {
			newDirection = direction + 1;
		}
		return newDirection;
	}
}