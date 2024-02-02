package main.java.com.leetcode._1402;

import java.util.Arrays;

public class ReducingDishes {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int[][] dp = new int[satisfaction.length+1][satisfaction.length+2];
        for (int i = 0; i <= satisfaction.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = satisfaction.length-1; i >= 0; i--) {
            for (int j = 1; j <= satisfaction.length; j++) {
                dp[i][j] = Math.max(satisfaction[i]*j+dp[i+1][j+1], dp[i+1][j]);
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        ReducingDishes r = new ReducingDishes();
        System.out.println(r.maxSatisfaction(new int[]{-1,-8,0,5,-9}));//Output: 14
        System.out.println(r.maxSatisfaction(new int[]{4,3,2}));//Output: 20
        System.out.println(r.maxSatisfaction(new int[]{-1,-4,-5}));//Output: 0
    }
}
