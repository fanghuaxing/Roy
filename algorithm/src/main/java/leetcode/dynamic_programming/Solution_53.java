package leetcode.dynamic_programming;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        //    1) 确定状态转移公式, 辅助dp数组的下标含义
        //    2) 初始化dp数组
        //    3) 根据题目条件确定遍历顺序, 并实现状态转移公式
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1]+nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public int maxSubArrayByRoy(int[] nums) {
        int result = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre+nums[i]);
            result = Math.max(result, pre);
        }
        return result;
    }
}