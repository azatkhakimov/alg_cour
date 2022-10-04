package leetcode._322;

import java.util.Arrays;

//https://www.youtube.com/watch?v=1R0_7HqNaW0
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5}, 11));//Output: 3
        System.out.println(coinChange.coinChange(new int[]{2}, 3));//Output: -1
        System.out.println(coinChange.coinChange(new int[]{1}, 0));//Output: 0
    }
}
