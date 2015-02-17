package leetcode;

/*
 Given a collection of numbers that might contain duplicates,
 return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] num) {
		if (num == null)
			return result;
		int n = num.length;
		Arrays.sort(num);
		LinkedList<Integer> candidate = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			candidate.add(num[i]);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		buildList(candidate, list);
		return result;
	}

	void buildList(LinkedList<Integer> candidate, ArrayList<Integer> list) {
		if (candidate.size() == 0) {
			List<Integer> newList = new ArrayList<Integer>(list);
			if (!result.contains(newList))
				result.add(newList);
			return;
		} else {
			int pre = candidate.get(0);
			for (int i = 0; i < candidate.size(); i++) {
				if (i != 0 && candidate.get(i) == pre)
					continue;
				else {
					pre = candidate.get(i);
					LinkedList<Integer> candidateN = new LinkedList<Integer>(candidate);
					ArrayList<Integer> listN = new ArrayList<Integer>( list);
					candidateN.remove(i);
					listN.add(candidate.get(i));
					buildList(candidateN, listN);
				}

			}
		}

	}
}
