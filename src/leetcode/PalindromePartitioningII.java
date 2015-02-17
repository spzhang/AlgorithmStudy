package leetcode;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 */

public class PalindromePartitioningII {
	public int minCut(String s) {

		if (s == null || s.length() < 2)
			return 0;
		int n = s.length();
		int[] D = new int[n + 1]; // dp for cut
		boolean[][] P = new boolean[n][n]; // dp for palindrome
		for (int i = 0; i <= n; i++) {
			D[i] = n - i;
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || P[i + 1][j - 1])) {
					P[i][j] = true;
					D[i] = Math.min(D[i], D[j + 1] + 1);
				}
			}
		}

		return D[0] - 1;

	}
}