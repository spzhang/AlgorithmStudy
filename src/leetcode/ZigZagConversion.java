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

}

class ZigZagConversionSolution {
	public String convert(String s, int nRows) {
		if (nRows <= 0 || s == null || s.length() == 0)
			return "";
		if (nRows == 1)
			return s;
		char[][] rslt = new char[nRows][s.length()];

		boolean downflag = true;
		int r = 0;
		int c = 0;
		int i = 0;

		while (i < s.length()) {
			char curChar = s.charAt(i);
			if (downflag == false) {
				if (r == 0) {
					rslt[r][c] = curChar;
					downflag = true;
					r++;
				} else {
					rslt[r][c] = curChar;
					c++;
					r--;
				}
			} else {
				if (r == nRows - 1) {
					rslt[r][c] = curChar;
					downflag = false;
					c++;
					r--;
				} else {
					rslt[r][c] = curChar;
					r++;
				}
			}
			i++;
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < nRows; j++) {
			sb.append(getString(rslt[j]));
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