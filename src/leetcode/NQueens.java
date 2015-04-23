package leetcode;

/*
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:
 */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	List<String[]> results = new ArrayList<String[]>();
	int[] result;

	public List<String[]> solveNQueens(int n) {
		if (n == 0)
			return results;
		result = new int[n];
		build(0, n);
		return results;
	}

	void build(int lvl, int n) {
		if (lvl == n) {
			String[] s = new String[n];
			for (int i = 0; i < n; i++) {
				s[i] = buildString(result[i], n);
			}
			results.add(s);
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				if (check(lvl, i)) {
					result[lvl] = i;
					build(lvl + 1, n);
				}
			}
		}
	}

	boolean check(int lvl, int i) {
		for (int j = 0; j < lvl; j++) {
			if (result[j] == i)			// check vertical
				return false;
			if (Math.abs(lvl - j) == Math.abs(result[j] - i))
				// check across
				return false;
		}
		return true;
	}

	String buildString(int i, int n) { 
		// convert int array to string
		int j = 0;
		StringBuilder sb = new StringBuilder();
		while (j < n) {
			if (j == i - 1) {
				sb.append('Q');
			} else {
				sb.append('.');
			}
			j++;
		}
		return sb.toString();
	}
}

// backtracking...