package leetcode;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStockIII {

}

class BestTimeToBuyAndSellStockIIISolution {
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;// one of zero days, cannot sell
		// break the problem in to subproblems, what is the max profit if i
		// decide to buy and sell one stock on or before day i
		// and the other stock after day i

		int[] left = new int[prices.length];// store the max profit so far for
											// day [0,i] for i from 0 to n
		int[] right = new int[prices.length];// store the max profit so far for
												// the days [i,n] for i from 0
												// to n
		int minl, maxprofit, maxr, profit;

		maxprofit = 0;// lower bound on profit
		minl = Integer.MAX_VALUE;// minimum price so far for populating left
									// array
		for (int i = 0; i < left.length; i++) {
			if (prices[i] < minl)
				minl = prices[i];// check if this price is the minimum price so
									// far
			profit = prices[i] - minl;// get the profit of selling at current
										// price having bought at min price so
										// far
			if (profit > maxprofit)
				maxprofit = profit;// if the profit is greater than the profit
									// so far, update the max profit
			left[i] = maxprofit;
		}

		maxprofit = 0;// reset maxprofit to its lower bound
		maxr = Integer.MIN_VALUE;// maximum price so far for populating the
									// right array
		// same line of reasoning as the above
		for (int i = left.length - 1; i >= 0; i--) {
			if (prices[i] > maxr)
				maxr = prices[i];
			profit = maxr - prices[i];
			if (profit > maxprofit)
				maxprofit = profit;
			right[i] = maxprofit;
		}
		// get the best by combining the subproblems as described above
		int best = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (left[i] + right[i + 1] > best)
				best = left[i] + right[i + 1];
		}
		best = best > maxprofit ? best : maxprofit;
		// in total 3 passes required and 2 extra arrays of size n
		return best;

	}

}