package leetcode.dynamic_programming;

import org.junit.Test;

public class Solution_121 {
    public int maxProfit(int[] prices) {
        //3. 动态规划的解题步骤
        //    1) 确定状态转移公式, 辅助dp数组的下标含义
        //    2) 初始化dp数组
        //    3) 根据题目条件确定遍历顺序, 并实现状态转移公式
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length-1][0];

    }

    public int maxProfitByRoy(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profitMax = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profitMax = Math.max(profitMax, prices[i] - min);
        }
        return profitMax;

    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution_121().maxProfitByRoy(prices));
    }
}