package leetcode;

/*
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container. 
 */

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxA = 0;
		int i = 0;
		int j = height.length - 1;

		while (i < j) {
			int curArea = (j - i) * (Math.min(height[i], height[j]));
			maxA = Math.max(curArea, maxA);
			if (height[i] < height[j])
				i++;
			else
				j--;
		}

		return maxA;
	}
}

