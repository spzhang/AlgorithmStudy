package leetcode;

/*
 Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null)
			return "";
		int n = strs.length;
		if (n == 0)
			return "";
		if (n == 1)
			return strs[0];
		char[] result = strs[0].toCharArray();
		int length = strs[0].length();

		for (int i = 1; i < n; i++) {
			String tmpstr = strs[i];
			int m = tmpstr.length();
			length = m < length ? m : length;
			for (int j = 0; j < length; j++) {
				if (result[j] != tmpstr.charAt(j)) {
					length = j;
					break;
				}
			}
			if (length == 0)
				break;
		}

		if (length == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(result[i]);
		}
		return sb.toString();

	}
}

/*
 * 逐个对比， 一个全局变量维护最长长度 
 */
