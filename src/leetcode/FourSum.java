package leetcode;

/*
 (k sum questions, look at evernote!)
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:

 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.

 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class FourSum {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> fourSum(int[] num, int target) {
		class Pair {
			int a;
			int ai;
			int b;
			int bi;

			public Pair(int a, int ai, int b, int bi) {
				this.a = a;
				this.ai = ai;
				this.b = b;
				this.bi = bi;
			}
		}

		if (num == null || num.length < 4)
			return result;
		Arrays.sort(num);
		TreeMap<Integer, List<Pair>> map = new TreeMap<Integer, List<Pair>>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int sum = num[i] + num[j];
				if (map.containsKey(sum)) {
					List<Pair> list = map.get(sum);
					list.add(new Pair(num[i], i, num[j], j));
					map.put(sum, list);
				} else {
					List<Pair> list = new ArrayList<Pair>();
					list.add(new Pair(num[i], i, num[j], j));
					map.put(sum, list);
				}

			}
		}

		int ival = map.firstKey();
		int jval = map.lastKey();
		while (ival < jval) {
			if (ival + jval == target) {
				for (Pair ipairs : map.get(ival)) {
					for (Pair jpairs : map.get(jval)) {
						if (jpairs.ai > ipairs.bi || ipairs.ai > jpairs.bi) {
							List<Integer> newList = Arrays.asList(ipairs.a,
									ipairs.b, jpairs.a, jpairs.b);
							if (!result.contains(newList))
								result.add(newList);
						}
					}
				}
				jval = map.lowerKey(jval);
				ival = map.higherKey(ival);

			} else if (ival + jval > target) {
				jval = map.lowerKey(jval);

			} else {
				ival = map.higherKey(ival);
			}
		}

		if (ival == jval && ival + jval == target) {
			for (Pair ipairs : map.get(ival)) {
				for (Pair jpairs : map.get(jval)) {
					if (jpairs.ai > ipairs.bi || ipairs.ai > jpairs.bi) {
						if (jpairs.ai > ipairs.bi) {
							List<Integer> newList = Arrays.asList(ipairs.a,
									ipairs.b, jpairs.a, jpairs.b);
							if (!result.contains(newList))
								result.add(newList);
						}
					}
				}
			}
		}

		return result;
	}
}