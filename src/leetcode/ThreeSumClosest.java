package leetcode;

/*
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {

}

class ThreeSumClosestSolution {
	int[] result = new int[3];
	int close = 0;

	public int threeSumClosest(int[] num, int target) {
		if (num == null)
			return 0;
		if (num.length <= 3) {
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum += num[i];
			}
			return sum;
		} else {
			close = num[0] + num[1] + num[2];
			subset(num, target, 0, 0);
			return close;
		}
	}

	void subset(int[] num, int target, int lvl, int count) {
		if (lvl == num.length && count < 3) {
			return;
		} else if (count == 3) {
			int temp = 0;
			for (int i = 0; i < 3; i++) {
				temp += result[i];
			}
			int min = Math.abs(close - target);
			int curMin = Math.abs(temp - target);
			if (curMin < min) {
				close = temp;
				return;
			} else {
				return;
			}
		} else if (close == target) {
			return;
		} else {
			result[count] = num[lvl];
			subset(num, target, lvl + 1, count + 1);
			result[count] = 0;
			subset(num, target, lvl + 1, count);
		}
	}

}