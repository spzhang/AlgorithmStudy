package leetcode;

/*
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */

public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] num) {
		int n = num.length;
		if (n == 0)
			return -1;
		int s = 0;
		int e = num.length - 1;
		while (s < e) {
			int mid = (s + e) / 2;
			if (num[s] == num[mid]) {
				if (num[mid] > num[e]) {
					s = mid + 1;
				} else {
					e--;
				}
			} else if (num[s] < num[mid]) {
				if (num[s] >= num[e]) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			} else {
				s++;
				e = mid;
			}
		}
		return num[s];
	}
}
