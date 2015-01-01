package leetcode;

/*
 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */

public class NQueensII {

}

class NQueensIISolution {

	public static int totalNQueens(int n) {
		int[] queenList = new int[n];
		return placeQueen(queenList, 0, n);
	}

	// 递归回溯8皇后，关键记录下到达了哪一行了
	public static int placeQueen(int[] queenList, int row, int n) {
		// Base Case, 已经完成任务了
		if (row == n) {
			return 1;
		}

		int cnt = 0;
		// 开始这一行的查找
		// 遍历第row行的所有列，测试哪一个位置是安全的
		for (int col = 0; col < n; col++) {
			if (isSafe(queenList, row, col)) {
				queenList[row] = col;
				cnt += placeQueen(queenList, row + 1, n);
			}
		}
		return cnt;
	}

	public static boolean isSafe(int[] queenList, int row, int col) {
		for (int preRow = 0; preRow < row; preRow++) {
			int preCol = queenList[preRow];
			if (preRow == row) { // 理论上不必检查，因为preRow是总是小于row的
				return false;
			}
			if (preCol == col) { // 检查是否在同一列
				return false;
			}
			if (row - preRow == col - preCol) { // 反对角线
				return false;
			}
			if (preRow + preCol == row + col) { // 正对角线
				return false;
			}
		}
		return true;
	}

}