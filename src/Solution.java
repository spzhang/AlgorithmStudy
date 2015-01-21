import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		String s1 = "abcdefghijklmn";
		String s2 = "efghijklmncadb";
		boolean result = s.isScramble(s1, s2) ;
		System.out.println(result);
		System.out.println(s1.substring(0, 5));
	}

	Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		int n = s1.length();
		int m = s2.length();
		if (n != m)
			return false;
		else if (n == 0)
			return true;
		else {
			buildMap(s1, 0);
		}
		if (map.get(s1).contains(s2))
			return true;
		else
			return false;
	}

	void buildMap(String s1, int lvl) {
		if (lvl == s1.length())
			return;
		HashSet<String> set = new HashSet<String>();
		if (lvl == 0) {
			set.add(s1.substring(0, 1));
			map.put(s1.substring(0, 1), set);
			buildMap(s1, lvl + 1);
		} else {
			for (int i = 1; i <= lvl; i++) {
				String part1 = s1.substring(0, i);
				String part2 = s1.substring(i, lvl + 1);
				if (!map.containsKey(part1))
					buildMap(part1, 0);
				if (!map.containsKey(part2))
					buildMap(part2, 0);
				for (String part1Str : map.get(part1)) {
					for (String part2Str : map.get(part2)) {
						set.add(part1Str + part2Str);
						set.add(part2Str + part1Str);
					}
				}
			}
			map.put(s1.substring(0, lvl + 1), set);
			buildMap(s1, lvl + 1);
		}
	}
}