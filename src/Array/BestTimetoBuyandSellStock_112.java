package Array;

/**
 * Array
 * description:给定整型数组 元素I表示股票第I天的价格 在限制只能进行一次操作(买一次 卖一次)的情况下 找出最大收益
 *
 Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5
 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0
 In this case, no transaction is done, i.e. max profit = 0.
 * author:mingzhe Xiang
 * date:2016/11/9
 */
public class BestTimetoBuyandSellStock_112 {

    /**
     *
     * 遍历数组：第I天卖出 则买入价格为0----->I-1中最小价格
     *
     *
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices){
        if (prices.length == 0)
            return 0 ;
        //截至当前天 前面日期中最小的价格 （即若以当前天为Sell时 前面应买入的价格）
        int nowMinPrice = prices[0];
        //若以当前天为Sell 最大收益
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            //以第I天为Sell日 前面0到i-1天中最小的价格(可看作买入价格)
            nowMinPrice = nowMinPrice < prices[i] ? nowMinPrice : prices[i];
            //以第I天为Sell日 maxProfit
            maxProfit = maxProfit < (prices[i] - nowMinPrice) ? prices[i] - nowMinPrice : maxProfit;
        }
        return maxProfit ;
    }


    /**
     * Discuss上MostVotes答案
     * 思路：该方式貌似是利用了动态规划的思想 【求数组最大子序列和】
     *  第I天卖出能达到的最大利润 必然是第i-1天卖出能获得的最大利润+（price[i]-prices[i-1]）的和。
     *  这就是典型的DP问题 最优解中包含了子问题的最优解
     *
     *  1.求得第i天卖出时 前I天所有买卖组合中最大组合
     *  2.记录前I天所有买卖组合中最大组合
     *
     *  该方法比自己的方式更通用 但最开始理解起来稍微有点绕
     * @param prices
     * @return
     */
    private static int mostVotes(int[] prices){

            int maxCur = 0, maxSoFar = 0;
            for(int i = 1; i < prices.length; i++) {
                maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
                maxSoFar = Math.max(maxCur, maxSoFar);
            }
            return maxSoFar;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,4,1,1,5,6}));
    }
}
