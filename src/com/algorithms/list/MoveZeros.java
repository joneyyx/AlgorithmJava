package com.algorithms.list;

import java.util.Arrays;

/**
 * @Description No.283
 * @Author ZhongYangyixiong
 * @Date 2022/6/9 4:34 PM
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * Follow up: Could you minimize the total number of operations done?
 *
 */
public class MoveZeros {
    public static void main(String[] args) {
        Solution solution = new MoveZeros().new Solution();
        int[] inputNums = new int[]{0,1,0,3,12};
        solution.moveZeroes(inputNums);
        System.out.println(Arrays.toString(inputNums));
    }

    // 双指针
//    * 时间复杂度：O(n)O(n)，其中 nn 为序列长度。每个位置至多被遍历两次
//    * 空间复杂度：O(1)O(1)。只需要常数的空间存放若干变量
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length,  left = 0,  right = 0;
            while (right < n) {
                if(nums[right] != 0) {
                    swap(nums, left, right);
                    left ++;
                }
                right ++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    class Solution2{
        public void moveZeros(int[] nums) {
            if(nums.length == 0 || nums == null) {
                return;
            }

        }
    }

}
