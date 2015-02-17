package leetcode;

/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity. 
 */
import java.util.Arrays;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		int n = num.length;
		if (n == 0)
			return 0;
		Arrays.sort(num);
		int count = 1;
		int max = count;
		int pre = num[0];
		for (int i = 1; i < n; i++) {
			if (num[i] - pre > 1) {
				if (count > max) {
					max = count;
				}
				count = 1;
			} else if (num[i] - pre == 1) {
				count++;
			}
			pre = num[i];
		}
		if (count > max) {
			max = count;
		}
		return max;
	}
}