package leetcode;

/*
 Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 */

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int n = num1.length();
		int m = num2.length();
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		String result = "0";
		int i = 0, j = 0;
		while (i < n) {
			j = 0;
			if (i < n - 4) {
				int curi = Integer.valueOf(num1.substring(n - 4 - i, n - i));
				while (j < m) {
					if (j < m - 4) {
						int curj = Integer.valueOf(num2.substring(m - 4 - j, m
								- j));
						int total = curi * curj;
						result = addString(result, String.valueOf(total), i + j);
						j = j + 4;
					} else {
						int curj = num2.charAt(m - 1 - j) - '0';
						int total = curi * curj;
						result = addString(result, String.valueOf(total), i + j);
						j++;
					}
				}
				i = i + 4;
			} else {
				int curi = num1.charAt(n - 1 - i) - '0';
				while (j < m) {
					if (j < m - 4) {
						int curj = Integer.valueOf(num2.substring(m - 4 - j, m
								- j));
						int total = curi * curj;
						result = addString(result, String.valueOf(total), i + j);
						j = j + 4;
					} else {
						int curj = num2.charAt(m - 1 - j) - '0';
						int total = curi * curj;
						result = addString(result, String.valueOf(total), i + j);
						j++;
					}
				}
				i++;
			}
		}
		return result;
	}

	public String addString(String str1, String str2, int offset) {
		StringBuffer sb1 = new StringBuffer(str1);
		StringBuffer sb2 = new StringBuffer(str2);

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < offset; i++) {
			sb2.append('0');
		}
		int n = sb1.length();
		int m = sb2.length();
		int shift = 0;
		if (n < m) {
			int i = 0;
			for (; i < n; i++) {
				int cur1 = sb1.charAt(n - 1 - i) - '0';
				int cur2 = sb2.charAt(m - 1 - i) - '0';
				int total = cur1 + cur2 + shift;
				if (total > 9) {
					shift = 1;
					total = total - 10;
					result.append(total);
				} else {
					shift = 0;
					result.append(total);
				}
			}
			for (; i < m; i++) {
				int cur2 = sb2.charAt(m - 1 - i) - '0';
				int total = cur2 + shift;
				if (total > 9) {
					shift = 1;
					total = total - 10;
					result.append(total);
				} else {
					shift = 0;
					result.append(total);
				}
			}
			if (shift == 1)
				result.append(shift);
		} else {
			int i = 0;
			for (; i < m; i++) {
				int cur1 = sb1.charAt(n - 1 - i) - '0';
				int cur2 = sb2.charAt(m - 1 - i) - '0';
				int total = cur1 + cur2 + shift;
				if (total > 9) {
					shift = 1;
					total = total - 10;
					result.append(total);
				} else {
					shift = 0;
					result.append(total);
				}
			}
			for (; i < n; i++) {
				int cur2 = sb1.charAt(n - 1 - i) - '0';
				int total = cur2 + shift;
				if (total > 9) {
					shift = 1;
					total = total - 10;
					result.append(total);
				} else {
					shift = 0;
					result.append(total);
				}
			}
			if (shift == 1)
				result.append(shift);
		}
		return result.reverse().toString();
	}
}

// 构建一个拥有偏移量的加法
// 四位数 四位数的乘 使成绩不会大于Integer.MAX_VALUE