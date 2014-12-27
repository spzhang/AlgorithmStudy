package leetcode;

/*
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2]. 
 */

public class RemoveDuplicatesFromSortedArray {

}

class RemoveDuplicatesFromSortedArraySolution {
	public int removeDuplicates(int[] A) {
		int n = A.length;
		if (n == 0)
			return 0;
		int prev = A[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (A[i] != prev) {
				prev = A[i];
				A[count] = A[i];
				count++;
			}
		}
		return count;
	}
}