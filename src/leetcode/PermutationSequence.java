package leetcode;

/*
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the kth permutation sequence.
 Note: Given n will be between 1 and 9 inclusive.
 (count one by one will lead to time out, so try find the number directly)
 */

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int total = factorial(n);
		StringBuffer candidate = new StringBuffer("123456789");
		candidate.substring(0, n);
		String result = new String();
		for (int i = 0; i < n; i++) { // count every bit
			total /= (n - i);
			int index = (k - 1) / total;
			result = result + candidate.charAt(index);
			candidate.deleteCharAt(index);
			k -= index * total;
		}
		return result;
	}

	int factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res *= i;
		return res;
	}
}
