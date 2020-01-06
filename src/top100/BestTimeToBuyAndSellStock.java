package top100;

/**
 *
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author: Xiang Mingzhe
 * @version BestTimeToBuyAndSellStock.java, v 0.1 2020/1/6 14:23 XiangMingZhe Exp $
 **/
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int maxStock = 0;
		int minBuyPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			minBuyPrice = Math.min(minBuyPrice, prices[i]);

			maxStock = Math.max(prices[i] - minBuyPrice, maxStock);
		}

		return maxStock;
	}

	public static void main(String[] args) {
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{2,4,1}));
	}
}
