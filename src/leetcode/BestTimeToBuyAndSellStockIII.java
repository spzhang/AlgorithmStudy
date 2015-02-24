package leetcode;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 global[i][j]=max(local[i][j],global[i-1][j])，
 local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，

 */

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int[] local = new int[3];
		int[] global = new int[3];
		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = 2; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0),
						local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[2];
	}
}
