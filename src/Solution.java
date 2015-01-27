import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	boolean result = false;

	public static void main(String[] args) {
		System.out.println("s".substring(1).length());
		Solution s = new Solution();
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		
		String[] list = {"a", "aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(list));
		System.out.println(s.wordBreak(str, dict));
	}

	public boolean wordBreak(String s, Set<String> dict) {

		if (s == null || dict == null)
			return false;
		if (s.length() == 0)
			return true;

		for (String str : dict) {
			if (s.startsWith(str))
				result = result || wordBreak(s.substring(str.length()), dict);
			if (result == true)
				break;
		}

		return result;

	}

}
