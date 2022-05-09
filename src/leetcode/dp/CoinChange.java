package leetcode.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    int value = dp[i - coins[j]] + 1;
                    dp[i] = Math.min(dp[i], value);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        assert 2 == coinChange.coinChange(new int[]{1,2,3}, 5);
    }
}
