package main.java.com.leetcode;

public class FindMaxKnapsackProfit {
    public  int findMaxKnapsackProfit(int capacity, int [] weights, int [] values) {
        int n = weights.length;
        int[][] dp = new int[n+1][capacity+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= capacity; j++){
                if(weights[i-1] <= j){
                    dp[i][j] = Math.max(values[i-1]+dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        var f = new FindMaxKnapsackProfit();
        System.out.println(f.findMaxKnapsackProfit(30, new int[]{10,20,30}, new int[]{22,33,44}));//55
        System.out.println(f.findMaxKnapsackProfit(5, new int[]{1,2,3,5}, new int[]{10,5,4,8}));//15
    }
}
