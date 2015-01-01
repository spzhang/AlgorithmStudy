package leetcode;

/*
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.
 */
public class FactorialTrailingZeroes {

}

class FactorialTrailingZeroesSolution {
	public int trailingZeroes(int n) {
		int count5 = 0;
		int a = n;
		while (a > 0) {
			a = a / 5;
			count5 += a;
		}
		return count5;

	}
}