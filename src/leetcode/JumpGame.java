package leetcode;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */

public class JumpGame {
	public boolean canJump(int[] A) {
		int n = A.length;
		if (n == 0)
			return false;
		if (n == 1)
			return true;
		int max = A[0];
		int cur = 0;
		while (max < n - 1) {
			if (cur == max && A[max] == 0)
				return false;
			else {
				if (cur + A[cur] > max)
					max = cur + A[cur];
			}
			cur++;
		}

		return true;
	}
}

// 贪心 一直找最远