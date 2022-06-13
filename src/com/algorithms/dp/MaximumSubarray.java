package com.algorithms.dp;

/**
 * @Description No.53
 * @Author ZhongYangyixiong
 * @Date 2022/6/10 6:57 PM
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));

    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];


            // dp[i]表示以i结尾的组合的最大值
         for (int i = 1; i < len; i++) {
                if(dp[i-1] > 0){
                    dp[i] = dp[i-1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }
            }

            // 比较各个dp的结果，取最大值
            int ans = dp[0];
            for (int i = 1; i < len; i++) {
                ans = Math.max(ans, dp[i]);
            }
            return ans;


        }

        /**
         * 精简代码，优化空间
         * @param nums
         * @return
         * 时间复杂度：O(N)，N 是输入数组的长度。
         */
        public int maxSubArray2(int[] nums) {
            int ans = nums[0];
            // 第一次未运行时，当前最大子序和为0
            int sum = 0;

            for (int num : nums) {
                // 前最大连续子序列和为 sum，结果为 ans
                if(sum>0) {
                    sum = num + sum;
                } else {
                    sum = num;
                }
                ans = Math.max(sum, ans);
            }
            return ans;
        }
    }
}
