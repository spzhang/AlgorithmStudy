package leetcode;

/*
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
 */
public class ImplementstrStr {

}

class ImplementstrStrSolution {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (needle == "")
			return 0;

		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length())
				break;
			if (haystack.substring(i, i + needle.length()).equals(needle))
				return i;

		}
		return -1;

	}
}