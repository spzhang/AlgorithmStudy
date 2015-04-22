package leetcode;

/*
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0 
 */

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		return search(A, start, end, target);
	}

	public int search(int[] A, int start, int end, int target) {
		int mid = (end + start) / 2;
		if ((end - start) / 2 == 0) {
			if (end > start) {
				if (A[start] >= target)
					return start;
				else if (A[end] >= target)
					return end;
				else
					return end + 1;
			} else {
				if (A[start] >= target)
					return start;
				else
					return start + 1;
			}
		}

		if (A[mid] == target)
			return mid;
		if (A[mid] > target)
			return search(A, start, mid - 1, target);
		else
			return search(A, mid + 1, end, target);

	}
}
