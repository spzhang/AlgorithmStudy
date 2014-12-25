package algorithm;



public class Test{
	
	public static void main(String[] args) {
		
		for(int i=1; i < 9; i++){
			Solution s = new Solution();
			System.out.println(s.totalNQueens(i));
		}
	}
}


class Solution {
    
    public int totalNQueens(int n) {
        int count = 0;
        int[] record = new int[n+1];
        int r = 0;
        return go(record, r, n, count);
    }
    
    public boolean check(int[] record, int r){
        for(int i = 0; i < r; i++){
            if( record[i] == record[r] ) return false;
            else if(record[r] - record[i] == r - i) return false;
            else if(record[i] - record[r] == r - i) return false;
        }
        return true;
    }
    
    public int go(int[] record, int r, int n, int count){
        record[r]++;
        if(r == 0 && record[r] > n){
            return count;
        }
        else if(r == n){
            count++;
            return go(record, r - 1, n, count);
        }
        else{
            if(record[r] > n){
               record[r] = 0;
               return go(record, r - 1, n, count);
            }
            else if(check(record, r)){
                return go(record, r + 1, n, count);
            }
            else{
                return go(record, r, n, count);
            }
        }

    }
} 
