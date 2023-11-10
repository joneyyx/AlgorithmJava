package com.algorithms.dp;

/**
 * @Author ZhongYangyixiong
 * @CreateTime 11/7/2023 2:10 PM
 * @Description: House Robber
 * <p>
 * https://leetcode.cn/problems/house-robber/description/
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class LC198_RobberHouse {
    public static void main(String[] args) {
        LC198_RobberHouse lc198RobberHouse = new LC198_RobberHouse();
        Solution solution = lc198RobberHouse.new Solution();
//        System.out.println(solution.rob(new int[] {2,7,9,3,1}));

        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
        System.out.println(solution.rob_space(new int[]{2, 1, 1, 2}));

    }


    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return nums[0];
            }

            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[1], nums[0]);
            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[len - 1];
        }


        // 只用到最后两个值，空间从O(n)-> O(1)
        public int rob_space(int[] nums) {
            int cur = 0;
            int pre = 0;

            for (int num : nums) {
                // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
                // dp[k] = max{ dp[k-1], dp[k-2] + i }

                int temp = Math.max(cur, pre + num);
                pre = cur;
                cur = temp;
                // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
            }
            return cur;
        }

    }
}
