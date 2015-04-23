package leetcode;

/*
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */

public class NQueensII {

	public int totalNQueens(int n) {
		int[] queenList = new int[n];
		return placeQueen(queenList, 0, n);
	}

	public int placeQueen(int[] queenList, int row, int n) {
		if (row == n) {
			return 1;
		}

		int count = 0;

		for (int col = 0; col < n; col++) {
			if (isSafe(queenList, row, col)) {
				queenList[row] = col;
				count += placeQueen(queenList, row + 1, n);
			}
		}
		return count;
	}

	public boolean isSafe(int[] queenList, int row, int col) {
		for (int preRow = 0; preRow < row; preRow++) {
			int preCol = queenList[preRow];
			if (preRow == row) {
				return false;
			}
			if (preCol == col) {
				return false;
			}
			if (row - preRow == col - preCol) {
				return false;
			}
			if (preRow + preCol == row + col) {
				return false;
			}
		}
		return true;
	}
}