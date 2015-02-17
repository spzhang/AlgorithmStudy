package leetcode;

/*
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */

public class FindPeakElement {
	public int findPeakElement(int[] num) {
		int n = num.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return 0;
		return findPeakAux(num, 0, n - 1);
	}

	int findPeakAux(int[] num, int s, int e) {
		int mid = (s + e) / 2;
		if (mid - 1 < s) {
			if (s == e)
				return s;
			else
				return num[s] > num[e] ? s : e;

		}

		if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1])
			return mid;
		else if (num[mid] > num[mid - 1])
			return findPeakAux(num, mid + 1, e);
		else
			return findPeakAux(num, s, mid - 1);
	}
}
