package leetcode;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int n = A.length;
		if (n <= 0)
			return -1;
		int s = 0;
		int e = n - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (A[mid] == target)
				return mid;
			else {
				if (A[s] <= A[mid]) {
					if (target > A[mid])
						s = mid + 1;
					else {
						if (target >= A[s])
							e = mid - 1;
						else
							s = mid + 1;
					}
				} else {
					if (target < A[mid])
						e = mid - 1;
					else {
						if (target <= A[e])
							s = mid + 1;
						else
							e = mid - 1;
					}
				}
			}
		}

		return -1;
	}
}
