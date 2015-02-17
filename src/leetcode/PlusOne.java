package leetcode;

/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		return plusOneAux(digits, n - 1);
	}

	int[] plusOneAux(int[] digits, int pos) {
		if (digits[pos] + 1 < 10) {
			digits[pos] = digits[pos] + 1;
			return digits;
		}
		if (pos > 0 && digits[pos] + 1 == 10) {
			digits[pos] = 0;
			return plusOneAux(digits, pos - 1);
		} else {
			int n = digits.length;
			int[] newDigits = new int[n + 1];
			newDigits[0] = 1;
			return newDigits;
		}
	}
}
