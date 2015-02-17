package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

/*
 * my solution will cause the time out
 */
class LongestSubstringWithoutRepeatingCharacters2 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			Character curChar = s.charAt(i);
			if (!map.containsKey(curChar)) {
				count++;
				map.put(curChar, count);
			} else {
				max = count > max ? count : max;
				int pos = map.get(curChar);
				reset(map, pos);
				count = count - pos;
				count++;
				map.put(curChar, count);
			}
		}

		return max;

	}

	void reset(Map<Character, Integer> map, int n) {
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() <= n) {
				map.put(entry.getKey(), 0);
			} else {
				map.put(entry.getKey(), entry.getValue() - n);
			}
		}
	}

}