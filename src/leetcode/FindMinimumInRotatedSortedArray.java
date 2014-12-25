package leetcode;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {

}

class FindMinimumInRotatedSortedArraySolution {
	public int findMin(int[] num) {
		int n = num.length;
		if (n == 0)
			return -1;
		if (n == 1)
			return num[0];
		int s = 0;
		int e = n - 1;
		return findMinAux(num, s, e);
	}

	int findMinAux(int[] A, int s, int e) {
		int mid = (s + e) / 2;
		if (s > mid - 1) {
			if (s == e)
				return A[s];
			else
				return A[s] < A[e] ? A[s] : A[e];
		}
		if (A[mid] < A[mid - 1])
			return A[mid];
		else if (A[mid] > A[e])
			return findMinAux(A, mid + 1, e);
		else
			return findMinAux(A, s, mid - 1);

	}
}