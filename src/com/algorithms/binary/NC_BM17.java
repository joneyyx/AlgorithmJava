package com.algorithms.binary;


public class NC_BM17 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        // 异常处理
        if (nums.length == 0) {
            return -1;
        }
        if (target < nums[0] || target > nums[nums.length -1 ]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right + 1)/2;
            if (target == nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        NC_BM17 bm17 = new NC_BM17();
        int[] input = new int[] {};
        int i = bm17.search(input, 13);
        System.out.println(i);
    }
}