package leetcode;

import java.util.Stack;

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		System.out.println(e.convertToTitle(27*26));
	}

	public String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<Integer>();
		while (n > 0) {
			int k = n % 26;
			if(k==0) {
				n=n-26;
				k=25;
			}else{
				k=k-1;
			}
			n = n / 26;
			s.push(k);

		}
		while(!s.isEmpty()){
			int cur = s.pop();
			sb.append((char)('A'+cur));
		}
		return sb.toString();

	}

}
