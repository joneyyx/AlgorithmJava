package com.algorithms.dp;

import java.util.Arrays;

/**
 * @Author ZhongYangyixiong
 * @CreateTime 11/7/2023 4:41 PM
 * @Description: Longest Increasing Subsequence
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LC300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LC300_LongestIncreasingSubsequence lc300LongestIncreasingSubsequence = new LC300_LongestIncreasingSubsequence();
        Solution solution = lc300LongestIncreasingSubsequence.new Solution();
        System.out.println(solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }


    class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;

            // dp[i] 表示：以 nums[i] 结尾 的「最长上升子序列」的长度
            int[] dp = new int[len];
            // 每个填充1
            Arrays.fill(dp, 1);

            for (int i = 1; i < len; i++) {
                // 从0开始，到i结尾找子串
               for (int j = 0; j < i; j ++) {
                   // 如果递增，dp[i]的长度，就是dp[j]的长度+1
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
               }
            }

            int res = 0;
            for (int i : dp) {
                res = Math.max(i, res);
            }
            return res;
            }
        }
    }
