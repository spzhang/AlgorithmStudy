import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] L = { "fooo", "barr", "wing", "ding", "wing" };
		Solution s = new Solution();
		System.out.println(s.findSubstring(S, L));
	}

	List<Integer> ret = new ArrayList<Integer>();

	public List<Integer> findSubstring(String S, String[] L) {
		int n = S.length();
		int m = L.length;
		if (n == 0 || m == 0)
			return ret;
		int k = L[0].length();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < m; i++) {
			if (map.containsKey(L[i])) {
				map.put(L[i], map.get(L[i]) + 1);
			} else {
				map.put(L[i], 1);
			}
		}

		for (int i = 0; i < n - m * k + 1; i++) {
			HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
			for (int j = 0; j < m; j++) {
				String s = S.substring(i+j*k, i+(j+1)*k);
				if(temp.containsKey(s)){
					if(temp.get(s)-1==0){
						temp.remove(s);
					}else{
						temp.put(s,temp.get(s)-1);
					}
				}else{
					break;
				}
			}
			if(temp.size()==0) ret.add(i);
		}
		return ret;
	}
}
