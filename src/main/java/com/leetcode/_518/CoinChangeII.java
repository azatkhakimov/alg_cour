package main.java.com.leetcode._518;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }

        for (int i = n-1; i >= 0; i--) {
            for(int j = 1; j <= amount; j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j]+dp[i][j-coins[i]];
                }
            }
        }
        return dp[0][amount];
    }

    public static void main(String[] args) {
        var c = new CoinChangeII();
        System.out.println(c.change(5, new int[]{1,2,5}));//Output: 4
        System.out.println(c.change(3, new int[]{2}));//Output: 0
        System.out.println(c.change(10, new int[]{10}));//Output: 1
    }
}
