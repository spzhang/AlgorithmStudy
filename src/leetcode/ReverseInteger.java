package leetcode;

/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 
 */

public class ReverseInteger {

}
class ReverseIntegerSolution {
    public int reverse(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        if ('-' == chars[0]) sb.append("-");
        for(int i=chars.length-1; i>=0; i--){
        	if(!('-' == chars[i])) sb.append(chars[i]);
        }
        
        int result = Integer.valueOf(sb.toString());
        return result;
    }
}
