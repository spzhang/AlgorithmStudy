package leetcode;

/*
 Given a string s and a dictionary of words dict,
 add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"]. 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static void main(String[] args) {
		String s = "catsanddog";
		String[] list = { "cat", "cats", "and", "sand", "dog" };
		Set<String> dict = new HashSet<String>(Arrays.asList(list));
		WordBreakII w = new WordBreakII();
		System.out.println(w.wordBreak(s, dict));
	}

	List<String> ret = new ArrayList<String>();
	List<String> list = new ArrayList<String>();
	Boolean[] possible;			// condition to prune

	public List<String> wordBreak(String s, Set<String> dict) {

		if (s == null || s.length() == 0)
			return ret;
		possible = new Boolean[s.length() + 1];
		process(s, dict, 0, 0);

		return ret;
	}

	public void process(String s, Set<String> dict, int pos, int lvl) {
		if (lvl == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String item : list) {
				sb.append(item);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			ret.add(sb.toString());
			return;
		}

		while (lvl < s.length()) {
			String cur = s.substring(pos, lvl + 1);
			if (dict.contains(cur)
					&& (possible[lvl + 1] == null || possible[lvl + 1] != false)) {
				int size = ret.size();
				list.add(cur);
				process(s, dict, lvl + 1, lvl + 1);
				if (ret.size() == size) {
					possible[lvl + 1] = false;
				}
				list.remove(list.size() - 1);
			}
			lvl++;
		}
	}

}
