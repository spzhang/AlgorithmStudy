package leetcode;

/*
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4]. 
 */
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int n = A.length;
		int[] result = { -1, -1 };
		if (n == 0)
			return result;

		int i = searchLeft(A, target, -1, 0, n - 1);
		int j = searchRight(A, target, -1, 0, n - 1);

		result[0] = i;
		result[1] = j;

		return result;

	}

	int searchLeft(int[] A, int target, int pos, int s, int e) {

		if (s >= e) {
			if (A[s] == target)
				pos = s;
			return pos;
		} else {
			int mid = (s + e) / 2;
			if (A[mid] < target) {
				return searchLeft(A, target, pos, mid + 1, e);
			} else if (A[mid] > target) {
				return searchLeft(A, target, pos, s, mid - 1);
			} else {
				pos = mid;
				return searchLeft(A, target, pos, s, mid - 1);
			}
		}

	}

	int searchRight(int[] A, int target, int pos, int s, int e) {

		if (s >= e) {
			if (A[s] == target)
				pos = s;
			return pos;
		} else {
			int mid = (s + e) / 2;
			if (A[mid] < target) {
				return searchRight(A, target, pos, mid + 1, e);
			} else if (A[mid] > target) {
				return searchRight(A, target, pos, s, mid - 1);
			} else {
				pos = mid;
				return searchRight(A, target, pos, mid + 1, e);
			}
		}
	}
}
