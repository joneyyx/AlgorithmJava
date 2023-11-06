package com.algorithms.twopointers;
// 合并两个有序数组

import java.util.Arrays;

public class NC_BM87 {
    public void merge(int A[], int m, int B[], int n) {
        // 指针
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;


        //
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k] = A[i];
                k--;
                i--;
            } else {
                A[k] = B[j];
                k--;
                j--;
            }
        }
        // 因为A、B已经排序，如果B没有遍历完，那么直接丢在A里面
        while (j >= 0) {
            A[k] = B[j];
            k--;
            j--;
        }
    }

    public static void main(String[] args) {
        NC_BM87 NCBm87 = new NC_BM87();
        int[] A = new int[100];
        A[0] = 4;
        A[1] = 5;
        A[2] = 6;
        NCBm87.merge( A, 3, new int[]{1,2,3},3);
        System.out.println(Arrays.toString(A));
    }

}
