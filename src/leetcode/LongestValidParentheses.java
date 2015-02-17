package leetcode;
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

import java.util.Stack;

public class LongestValidParentheses {
	Stack<Integer> lefts = new Stack<Integer>();

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int n = s.length();
        int[] counts = new int[n + 1];
        counts[0] = 0;
        lefts.push(-1);
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lefts.push(i);
                counts[i + 1] = 0;
            } else {
                int count;
                int lastLeft = lefts.pop();
                if (lastLeft != -1) {
                    if (s.charAt(i - 1) == ')') {
                        count = counts[i] + counts[lastLeft] + 2;
                        counts[i + 1] = count;
                        counts[lastLeft + 1] = count;
                    } else {
                        count = counts[i - 1] + 2;
                        counts[i + 1] = count;
                        counts[lastLeft + 1] = count;

                    }
                    longest = Math.max(longest, count);
                } else {
                    counts[i] = 0;
                    lefts.push(-1);
                }

            }
        }

        return longest;
    }
}
