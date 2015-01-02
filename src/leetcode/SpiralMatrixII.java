package leetcode;

/*
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,
 You should return the following matrix:

 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 */

public class SpiralMatrixII {

}

class SpiralMatrixIISolution {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0)
			return matrix;
		generateMatrixAux(matrix, 0, 0, 1, 1, n);
		return matrix;
	}

	void generateMatrixAux(int[][] matrix, int r, int c, int v, int d, int n) {
		switch (d) {
		case 1: // go right
			matrix[r][c] = v;
			if (c + 1 < n && matrix[r][c + 1] == 0) {
				generateMatrixAux(matrix, r, c + 1, v + 1, 1, n);
			} else if (r + 1 < n && matrix[r + 1][c] == 0) {
				generateMatrixAux(matrix, r + 1, c, v + 1, 2, n);
			} else
				return;
			break;
		case 2: // go down
			matrix[r][c] = v;
			if (r + 1 < n && matrix[r + 1][c] == 0) {
				generateMatrixAux(matrix, r + 1, c, v + 1, 2, n);
			} else if (c - 1 >= 0 && matrix[r][c - 1] == 0) {
				generateMatrixAux(matrix, r, c - 1, v + 1, 3, n);
			} else
				return;
			break;
		case 3:
			matrix[r][c] = v;
			if (c - 1 >= 0 && matrix[r][c - 1] == 0) {
				generateMatrixAux(matrix, r, c - 1, v + 1, 3, n);
			} else if (r - 1 >= 0 && matrix[r - 1][c] == 0) {
				generateMatrixAux(matrix, r - 1, c, v + 1, 4, n);
			} else
				return;
			break;
		case 4:
			matrix[r][c] = v;
			if (r - 1 >= 0 && matrix[r - 1][c] == 0) {
				generateMatrixAux(matrix, r - 1, c, v + 1, 4, n);
			} else if (c + 1 < n && matrix[r][c + 1] == 0) {
				generateMatrixAux(matrix, r, c + 1, v + 1, 1, n);
			} else
				return;
			break;
		}

	}
}