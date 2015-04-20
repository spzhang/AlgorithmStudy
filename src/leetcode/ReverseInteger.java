package leetcode;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321 
 */

public class ReverseInteger {
	public int reverse(int x) {
		int ret = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = ret * 10 + tail;
			if ((newResult - tail) / 10 != ret) {
				return 0;
			}
			ret = newResult;
			x = x / 10;
		}

		return ret;
	}
}

/*
 * 除法得余数 新结果每次乘10加余数
 * 中间的对比 如果结果不一样 说明到边界了
*/
