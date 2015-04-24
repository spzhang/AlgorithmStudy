package leetcode;

/*
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,

 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]

 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		if (n == 0)
			return 0;
		int m = obstacleGrid[0].length;
		if (m == 0)
			return 0;
		int[][] result = new int[n][m];
		if (obstacleGrid[0][0] == 1)
			return 0;
		if (m == 1 && n == 1)
			return 1;
		result[0][0] = 0;
		for (int j = 1; j < m; j++) {
			if (obstacleGrid[0][j] == 1 || result[0][j - 1] == -1)
				result[0][j] = -1;
			else {
				result[0][j] = 1;
			}
		}
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[i][0] == 1 || result[i - 1][0] == -1)
				result[i][0] = -1;
			else {
				result[i][0] = 1;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[i][j] == 1)
					result[i][j] = -1;
				else {
					if (result[i - 1][j] == -1 && result[i][j - 1] == -1)
						result[i][j] = -1;
					else if (result[i - 1][j] == -1)
						result[i][j] = result[i][j - 1];
					else if (result[i][j - 1] == -1)
						result[i][j] = result[i - 1][j];
					else
						result[i][j] = result[i - 1][j] + result[i][j - 1];
				}

			}
		}
		return result[n - 1][m - 1] == -1 ? 0 : result[n - 1][m - 1];

	}
}

// 一样是dp 只不过把不能到的地方标记为-1 如果本格是障碍物 直接-1 , 
// 如果上格是障碍物 左格不是 等于左格, 反之等于上格, 或上左之和