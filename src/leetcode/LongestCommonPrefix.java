package leetcode;

/*
 Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {

}

class LongestCommonPrefixSolution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null)
			return "";
		int n = strs.length;
		if (n == 0)
			return "";
		if (n == 1)
			return strs[0];
		char[] result = strs[0].toCharArray();
		int length = strs[0].length() - 1;

		for (int i = 1; i < n; i++) {
			String tmpstr = strs[i];
			int m = tmpstr.length() - 1;
			length = m < length ? m : length;
			for (int j = 0; j <= length; j++) {
				if (result[j] != tmpstr.charAt(j)) {
					length = j - 1;
					break;
				}
			}
			if (length == -1)
				break;
		}

		if (length == -1)
			return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= length; i++) {
			sb.append(result[i]);
		}
		return sb.toString();

	}
}