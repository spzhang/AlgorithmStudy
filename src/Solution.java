public class Solution {
	int[] result = new int[3];
	int close = 0;

	public static void main(String[] args) {
		int[] num = { -1 ,2, 1, -4 };
		
		Solution s = new Solution();
		System.out.println(s.threeSumClosest(num, 1));
		

	}

	public int threeSumClosest(int[] num, int target) {
		if (num == null)
			return 0;
		if (num.length <= 3) {
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum += num[i];
			}
			return sum;
		} else {
			subset(num, target, 0, 0);
			return close;
		}
	}

	void subset(int[] num, int target, int lvl, int count) {
		if (lvl == num.length && count < 3) {
			return;
		} else if (count == 3) {
			int temp = 0;
			for (int i = 0; i < 3; i++) {
				temp += result[i];
			}
			int min = Math.abs(close - target);
			int curMin = Math.abs(temp - target);
			if (curMin < min) {
				close = temp;
				return;
			} else {
				return;
			}
		} else {
			result[count] = num[lvl];
			subset(num, target, lvl + 1, count + 1);
			result[count] = 0;
			subset(num, target, lvl + 1, count);
		}
	}

}