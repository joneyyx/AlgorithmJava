package com.algorithms.dp;

/**
 * @Author ZhongYangyixiong
 * @CreateTime 11/9/2023 11:28 AM
 * @Description: 股票最佳买卖时间
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class LC121_BestTimeStock {

    public static void main(String[] args) {
        LC121_BestTimeStock lc121BestTimeStock = new LC121_BestTimeStock();
        Solution solution = lc121BestTimeStock.new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * //    时间复杂度O(n)2
     * //    空间复杂度O(1)
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            int ans = 0;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (prices[j] < prices[i]) {
                        ans = Math.max(ans, prices[i] - prices[j]);
                    }
                }
            }
            return ans;
        }


        /**
         * 维护历史最便宜价格即可，不需要每次都循环
         *
         * @param prices
         * @return
         */
        public int maxProfit2(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            int ans = 0;
            int minPrice =  prices[0];
            for (int i = 1; i < len; i++) {
                // 最大利润
                ans = Math.max(ans, prices[i] - minPrice);

                minPrice = Math.min(prices[i], minPrice);
            }
            return ans;
        }


        /**
         * dp思想，
         * pre是i-1的最大利润
         * 每次都是计算以i结尾的最大利润
         * 如果今pre+diff<pre说明，以price[i]结尾的利润还不如昨天
         *
         * @param prices
         * @return
         */
        public int maxProfit3(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }
            int res = 0;
            // 前一天卖掉的最大利润
            int pre = 0;
            for (int i = 1; i < len; i++) {
                // 当天的利润差 = 今天价格-昨天的价格
                int diff = prices[i] - prices[i - 1];
                // 状态转移：第i天的最大利润 = 第i-1天的最大利润 + 利润diff
                pre = Math.max(diff + pre, 0);
                res = Math.max(pre, res);
            }
            return res;
        }
    }


}
