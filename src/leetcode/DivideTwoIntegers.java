package leetcode;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		boolean isNeg = (dividend ^ divisor) >>> 31 == 1;
		int ret = 0;
		if (dividend == Integer.MIN_VALUE) {
			dividend += Math.abs(divisor);
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
			ret++;
		}
		if (divisor == Integer.MIN_VALUE) {
			return ret;
		}

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int digit = 0;
		while (divisor <= (dividend >> 1)) {
			divisor <<= 1;
			digit++;
		}
		while (digit >= 0) {
			if (dividend >= divisor) {
				ret += 1 << digit;
				dividend -= divisor;
			}
			divisor >>= 1;
			digit--;
		}
		return isNeg ? -ret : ret;
	}
}
