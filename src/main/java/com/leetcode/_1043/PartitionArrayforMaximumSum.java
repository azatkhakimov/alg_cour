package main.java.com.leetcode._1043;

import java.util.Arrays;

public class PartitionArrayforMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        for (int start = n - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(n, start+k);
            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start]  =Math.max(dp[start], dp[i+1] + currMax*(i-start+1));
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        var p = new PartitionArrayforMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));//Output: 84
        System.out.println(p.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));//Output: 83
        System.out.println(p.maxSumAfterPartitioning(new int[]{1}, 1));//Output: 1
    }
}
