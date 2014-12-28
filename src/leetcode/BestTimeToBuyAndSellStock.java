package leetcode;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

public class BestTimeToBuyAndSellStock {

}

class BestTimeToBuyAndSellStockSolution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 0)
			return 0;
		int lowest = prices[0];
		int currentMax = 0;
		int maxMax = 0;
		for (int i = 0; i < n; i++) {
			if (prices[i] < lowest) {
				lowest = prices[i];
			} else {
				currentMax = prices[i] - lowest;
				if (currentMax > maxMax)
					maxMax = currentMax;
			}
		}
		return maxMax;
	}
}