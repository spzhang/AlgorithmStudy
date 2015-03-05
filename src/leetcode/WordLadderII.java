package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*

 Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary

 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]

 Return

 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]


 */

public class WordLadderII {
	Map<String, List<String>> map;
	List<List<String>> results;

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		results = new ArrayList<List<String>>();
		if (dict.size() == 0)
			return results;

		int min = Integer.MAX_VALUE;

		Queue<String> queue = new ArrayDeque<String>();
		queue.add(start);

		map = new HashMap<String, List<String>>();

		Map<String, Integer> ladder = new HashMap<String, Integer>();
		for (String string : dict)
			ladder.put(string, Integer.MAX_VALUE);
		ladder.put(start, 0);

		dict.add(end);
		// BFS: Dijisktra search
		while (!queue.isEmpty()) {

			String word = queue.poll();

			int step = ladder.get(word) + 1;
			// 'step' indicates how many steps are needed to travel to one word.
			if (step > min)
				break;

			for (int i = 0; i < word.length(); i++) {
				StringBuilder builder = new StringBuilder(word);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					builder.setCharAt(i, ch);
					String new_word = builder.toString();
					if (ladder.containsKey(new_word)) {

						if (step > ladder.get(new_word))
							// Check if it is the shortest path to one word.
							continue;
						else if (step < ladder.get(new_word)) {
							queue.add(new_word);
							ladder.put(new_word, step);
						}
						// Do not insert the same word inside the queue twice

						if (map.containsKey(new_word)) // Build adjacent Graph
							map.get(new_word).add(word);
						else {
							List<String> list = new LinkedList<String>();
							list.add(word);
							map.put(new_word, list);
						}
						if (new_word.equals(end))
							min = step;

					}
				}
			}
		}

		// BackTracking
		LinkedList<String> result = new LinkedList<String>();
		backTrace(end, start, result);

		return results;
	}

	private void backTrace(String word, String start, List<String> list) {
		if (word.equals(start)) {
			list.add(0, start);
			results.add(new ArrayList<String>(list));
			list.remove(0);
			return;
		}
		list.add(0, word);
		if (map.get(word) != null)
			for (String s : map.get(word))
				backTrace(s, start, list);
		list.remove(0);
	}
}
