import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.restoreIpAddresses("010010"));
	}

	List<String> result = new ArrayList<String>();
	List<String> temp = new ArrayList<String>();

	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length() < 4 || s.length() > 12)
			return result;
		int n = s.length();
		build(s, 0, 0, n);

		return result;
	}

	void build(String s, int pos, int count, int n) {
		if (pos == n && count == 4) {
			result.add(toString(temp));
		} else if (pos > n - 1) {
			return;
		} else if (count > 4) {
			return;
		} else {

			String cur1 = s.substring(pos, pos + 1);
			temp.add(cur1);
			build(s, pos + 1, count + 1, n);
			temp.remove(temp.size() - 1);
			if (pos < n - 1) {
				String cur2 = s.substring(pos, pos + 2);
				if (!cur2.startsWith("0")) {
					temp.add(cur2);
					build(s, pos + 2, count + 1, n);
					temp.remove(temp.size() - 1);
					if (pos < n - 2) {
						String cur3 = s.substring(pos, pos + 3);
						if (Integer.valueOf(cur3) < 256 && !cur3.startsWith("0")) {
							temp.add(cur3);
							build(s, pos + 3, count + 1, n);
							temp.remove(temp.size() - 1);
						}

					}
				}
			}

		}
	}

	String toString(List<String> temp) {
		StringBuffer sb = new StringBuffer();
		for (String s : temp) {
			sb.append(s);
			sb.append(".");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
