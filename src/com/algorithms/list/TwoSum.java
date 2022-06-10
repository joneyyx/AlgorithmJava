package com.algorithms.list;

import java.util.Arrays;

/**
 * @Description
 * @Author ZhongYangyixiong
 * @Date 2022/6/6 1:14 PM
 */

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]

        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]

        Constraints:
        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.

        Follow-up:Can you come up with an algorithm that is less than O(n2) time complexity?*/

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    /**
     * 该算法的时间复杂度为O(n²)，空间复杂度为O(1)。
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            //知识点：i++和++i的区别
            for (int i = 0; i < n; i++) {
                //对于每个数，它都与前面的数进行过匹配，因此从它之后的数开始匹配
                for (int j = i + 1; j < n; j++) {
                    if (target == nums[i] + nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
    }


}