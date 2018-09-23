package Leetcode;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。*/
public class MaxSubArry {
    public int maxSubArray(int[] nums) {
        //动态规划
        //dp[i] = max{nums[i], dp[i-1]+A[i]}

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
        }

        int max = dp[0];
        for (int j = 1; j<dp.length; j++){
            if (dp[j] > max){
                max = dp[j];
            }
        }

        return max;
    }
}
