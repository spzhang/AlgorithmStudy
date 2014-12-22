package leetcode;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
import java.util.TreeMap;

public class MajorityElement {

}

class MajorityElementSolution {
	public int majorityElement(int[] num) {
		int n = num.length;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {

			if (map.containsKey(num[i]))
				map.put(num[i], map.get(num[i]) + 1);
			else
				map.put(num[i], 1);

			if (map.get(num[i]) > n / 2)
				return num[i];

		}
		return 0;

	}
}