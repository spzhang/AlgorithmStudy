package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {

}

class RepeatedDNASequencesSolution {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() < 11)
			return res;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> unique = new HashSet<Integer>();

		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i < 9) {
				hash = (hash << 2) + map.get(c);
			} else {
				hash = (hash << 2) + map.get(c);
				hash &= (1 << 20) - 1;
				if (set.contains(hash) && !unique.contains(hash)) {
					res.add(s.substring(i - 9, i + 1));
					unique.add(hash);
				} else {
					set.add(hash);
				}
			}
		}

		return res;

	}
}