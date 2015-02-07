import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

	}
	
	class Info{
		boolean istail;
		String longest;
		int lastpos;
	}

	ArrayList<Info> list = new ArrayList<Info>();
	
	public String longestPalindrome(String s) {
		if(s==null) return null;
		int n = s.length();
		if(n==0||n==1) return s;
		Info first = new Info();
		first.istail = true;
		first.longest = s.substring(0,1);
		first.lastpos = 0;
		list.add(first);
		for(int i = 1; i<n; i++){
			Info lastInfo = list.get(list.size()-1);
			Info newInfo = new Info();
			String cur = s.substring(i,i+1);
			if(lastInfo.istail){
				
			}else{
				if(cur.equals(s.substring(i-1, i))){
					
				}
			}
			list.add(newInfo);
		}
		
		return list.get(list.size()-1).longest;
		
		
	}

}
