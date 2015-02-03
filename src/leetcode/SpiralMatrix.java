package leetcode;

/*
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]

 You should return [1,2,3,6,9,8,7,4,5]. 
 */
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

}

class SpiralMatrixSolution {
	int leftBound, rightBound, upperBound, lowerBound;
	List<Integer> result = new ArrayList<Integer>();

	public List<Integer> spiralOrder(int[][] matrix) {

		if (matrix == null)
			return null;
		int n = matrix.length;
		if (n == 0)
			return result;
		int m = matrix[0].length;
		if (m == 0)
			return result;
		set_boundary(n, m);
		goRight(matrix, 0, 0);
		return result;
	}

	void set_boundary(int n, int m) {
		leftBound = 0;
		upperBound = 0;
		rightBound = m - 1;
		lowerBound = n - 1;
	}

	void goRight(int[][] matrix, int i, int j) {
		if (j > rightBound)
			return;
		else {
			while (j <= rightBound) {
				int cur = matrix[i][j];
				result.add(cur);
				j++;
			}
			upperBound++;
			goDown(matrix, i + 1, j - 1);
		}
	}

	void goDown(int[][] matrix, int i, int j) {
		if (i > lowerBound)
			return;
		else {
			while (i <= lowerBound) {
				int cur = matrix[i][j];
				result.add(cur);
				i++;
			}
			rightBound--;
			goLeft(matrix, i - 1, j - 1);
		}

	}

	void goLeft(int[][] matrix, int i, int j) {
		if (j < leftBound)
			return;
		else {
			while (j >= leftBound) {
				int cur = matrix[i][j];
				result.add(cur);
				j--;
			}
			lowerBound--;
			goUp(matrix, i - 1, j + 1);
		}
	}

	void goUp(int[][] matrix, int i, int j) {
		if (i < upperBound)
			return;
		else {
			while (i >= upperBound) {
				int cur = matrix[i][j];
				result.add(cur);
				i--;
			}
			leftBound++;
			goRight(matrix, i + 1, j + 1);
		}
	}
}