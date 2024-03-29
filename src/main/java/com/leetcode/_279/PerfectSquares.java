package main.java.com.leetcode._279;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i-j*j>=0){
                min = Math.min(min, dp[i-j*j]+1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(12));//Output: 3
        System.out.println(perfectSquares.numSquares(13));//Output: 2

    }
}
