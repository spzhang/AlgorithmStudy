package leetcode;

/*
 Given a set of candidate numbers (C) and a target number (T), 
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null)
			return result;
		Arrays.sort(candidates);
		subsets(candidates, target, 0, 0);
		return result;
	}

	void subsets(int[] candidates, int target, int sum, int level) {

		if (sum > target || level == candidates.length) {
			return;
		} else if (sum == target) {
			List<Integer> newList = new ArrayList<Integer>(list);
			if (!result.contains(newList)) {
				result.add(newList);
			}
			return;
		} else {
			list.add(candidates[level]);
			subsets(candidates, target, sum + candidates[level], level);
			list.remove(list.size() - 1);
			subsets(candidates, target, sum, level + 1);
		}

	}
}

// 回溯 每次加当前 跟2的区别是加完不进位