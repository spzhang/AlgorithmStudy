package leetcode;

/*

 Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]

 Note: Each word is guaranteed not to exceed L in length. 

 */

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int L) {

        List<String> ret = new ArrayList<String>();

        int n = words.length;

        if (words == null || n == 0) return ret;

        int i = 0, len;
        ArrayList<String> temp = new ArrayList<String>();
        while (i < n - 1) {
            len = 0;
            temp.clear();
            while (i < n - 1 && len + words[i].length() <= L) {
                len += words[i].length();
                temp.add(words[i]);
                i++;
            }
            if (i != n - 2) {

            } else {

            }
        }


        return ret;

    }

}
