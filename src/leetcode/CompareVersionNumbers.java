package leetcode;

/*
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {

	public static void main(String[] args) {
		CompareVersionNumbers s = new CompareVersionNumbers();
		System.out.println(s.compareVersion("12.0", "12"));
	}

	public int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null)
			return 0;
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int l1 = v1.length - 1;
		int l2 = v2.length - 1;

		int a = l1;
		int b = l2;
		while (a >= 0 && b >= 0) {
			if (Integer.parseInt(v1[l1 - a]) > Integer.parseInt(v2[l2 - b])) {
				return 1;
			} else if (Integer.parseInt(v1[l1 - a]) < Integer.parseInt(v2[l2
					- b])) {
				return -1;
			} else {
				a--;
				b--;
			}
		}
		while (a >= 0) {
			if (Integer.parseInt(v1[l1 - a]) != 0)
				return 1;
			else a--;
		}
		while (b >= 0) {
			if (Integer.parseInt(v2[l2 - b]) != 0)
				return -1;
			else b--;
		}
		return 0;

	}
}
