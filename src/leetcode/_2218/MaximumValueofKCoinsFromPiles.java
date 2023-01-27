package leetcode._2218;

import java.util.Arrays;
import java.util.List;

public class MaximumValueofKCoinsFromPiles {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int currentSum = 0;
                for(int currentCoins = 0; currentCoins <= Math.min(piles.get(i-1).size(), coins); currentCoins++){
                    if(currentCoins > 0){
                        currentSum += piles.get(i-1).get(currentCoins-1);
                    }
                    dp[i][coins] = Math.max(dp[i][coins], dp[i-1][coins-currentCoins]
                    + currentSum);
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        MaximumValueofKCoinsFromPiles m = new MaximumValueofKCoinsFromPiles();
        System.out.println(m.maxValueOfCoins(Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9)), 2));//Output: 101
        System.out.println(m.maxValueOfCoins(Arrays.asList(List.of(100), List.of(100), List.of(100), List.of(100),
                List.of(100), List.of(100), Arrays.asList(1,1,1,1,1,1,700)), 7));//Output: 706
    }
}
