package main.java.com.leetcode._1575;

import java.util.Arrays;

public class CountAllPossibleRoutes {


    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel+1];
        Arrays.fill(dp[finish], 1);
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if(k == i){
                        continue;
                    }
                    if(Math.abs(locations[i]-locations[k]) <= j){
                        dp[i][j] = (dp[i][j]+dp[k][j-Math.abs(locations[i]-locations[k])])
                                % 1_000_000_007;
                    }
                }
            }
        }
        return dp[start][fuel];
    }

    public static void main(String[] args) {
        var c = new CountAllPossibleRoutes();
        System.out.println(c.countRoutes(new int[]{2,3,6,8,4}, 1, 3,5));//Output: 4
        System.out.println(c.countRoutes(new int[]{4,3,1}, 1, 0, 6));//Output: 5
        System.out.println(c.countRoutes(new int[]{5,2,1}, 0,  2, 3));//Output: 0
    }
}
