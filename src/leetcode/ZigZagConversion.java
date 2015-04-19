package leetcode;

/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);

 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 */

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows <= 0 || s == null || s.length() == 0)
			return "";
		if (nRows == 1)
			return s;
		char[][] ret = new char[nRows][s.length()];

		boolean downflag = true;
		int r = 0;	//row
		int c = 0;	//column
		int i = 0;	//index

		while (i < s.length()) {
			char curChar = s.charAt(i);
			if (downflag == false) {
				if (r == 0) {
					ret[r][c] = curChar;
					downflag = true;
					r++;
				} else {
					ret[r][c] = curChar;
					c++;
					r--;
				}
			} else {
				if (r == nRows - 1) {
					ret[r][c] = curChar;
					downflag = false;
					c++;
					r--;
				} else {
					ret[r][c] = curChar;
					r++;
				}
			}
			i++;
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < nRows; j++) {
			sb.append(getString(ret[j]));
		}
		return sb.toString();
	}

	String getString(char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != '\u0000')
				sb.append(chars[i]);
		}
		return sb.toString();
	}
}

/*
 * 创建zig字符串对应的2纬数组 ，然后重新读出字符串
 */
