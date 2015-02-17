package leetcode;

/*
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code". 
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return false;
		else if (dict.contains(s))
			return true;
		
		//the first letter that dict cannot build.
		List<Integer> starts = new LinkedList<Integer>();
		starts.add(0);
		for (int end = 1; end <= s.length(); end++) {
			for (int i = 0; i < starts.size(); i++) {
				if (dict.contains(s.substring(starts.get(i), end))) {
					starts.add(0, end);
					break;
				}
			}
		}
		return (starts.get(0) == s.length());
	}
}