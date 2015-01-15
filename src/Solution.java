public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] num = {1,1};
		s.nextPermutation(num);
		System.out.println(num);
	}

	 void nextPermutation(int[] num) {
		int n = num.length;
		if (n == 0 || n == 1)
			return;
		int index = n - 1;
		while (index > 0) {
			if (num[index] > num[index - 1]) {
				break;
			}
			index--;
		}
		if (index == 0) {
			reverse(num, 0, n - 1);
			return;
		} else {
			int left = index - 1;
			while (index < n && num[index] > num[left]) {
				index++;
			}
			int right = index - 1;
			exchange(num, left, right);
			reverse(num, left + 1, right);
		}
	}

	void exchange(int[] num, int l, int r) {
		int tmp = num[r];
		num[r] = num[l];
		num[l] = tmp;
	}

	void reverse(int[] num, int i, int j) {
		int l = i;
		int r = j;
		while (l < r) {
			exchange(num, l, r);
			l++;
			r--;
		}

	}

}