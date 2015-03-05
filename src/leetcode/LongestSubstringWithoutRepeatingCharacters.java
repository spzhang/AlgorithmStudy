package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] ch = s.toCharArray();
		int max = 0;
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			count++;
			if (map.containsKey(ch[i])) {
				count = Math.min(count, i - map.get(ch[i]));
			}
			map.put(ch[i], i);
			if (count > max)
				max = count;
		}
		return max;

	}

}

