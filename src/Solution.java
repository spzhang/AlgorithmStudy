
public class Solution {

	public static void main(String[] args) {
		System.out.println(Math.pow(1.00001, 123456));
		String a = "a".substring(0,1);
		System.out.println(a);
	}

	
	 public int minDistance(String word1, String word2) {
	        int n = word1.length();
	        int m = word2.length();
	        if(n == 0) return m;
	        if(m == 0) return n;
	        char[] w1 = word1.toCharArray();
	        char[] w2 = word2.toCharArray();
	        int[][] result = new int[n][m];
	        result[0][0] = w1[0] == w2[0] ? 1 : 0;
	        for(int i = 1; i < m; i++){
	            result[0][i] = w1[i] == w2[i] ? result[0][i-1] + 1: result[0][i-1];
	        }
	        for(int i = 1; i < m; i++){
	            result[0][i] = w1[i] == w2[i] ? result[0][i-1] + 1: result[0][i-1];
	        }
	        
	        return 0;
	    }
}