package leetcode;

/*
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		int n = num.length;
		if (n == 0)
			return null;
		ArrayList<Integer> candidate = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			candidate.add(num[i]);
		}
		permuteAux(list, candidate, results);
		return results;
	}

	void permuteAux(ArrayList<Integer> list, ArrayList<Integer> candidate,
			List<List<Integer>> results) {
		int n = candidate.size();
		if (n == 0) {
			if (!results.contains(list))
				results.add(list);
		} else {
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> resultN = new ArrayList<Integer>(list);
				ArrayList<Integer> candidateN = new ArrayList<Integer>(
						candidate);
				int temp = candidate.get(i);
				resultN.add(temp);
				candidateN.remove(i);
				permuteAux(resultN, candidateN, results);
			}
		}
	}
}

// backtracking 注意 构建新容器的方法 不用clone
