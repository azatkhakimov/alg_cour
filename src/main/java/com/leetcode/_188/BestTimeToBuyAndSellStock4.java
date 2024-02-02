package main.java.com.leetcode._188;

public class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k >= len/2){
            return solve(prices);
        }
        int[][] t = new int[k+1][len];
        for (int i = 1; i <= k; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j-1], prices[j]+tempMax);
                tempMax = Math.max(tempMax, t[i-1][j-1]-prices[j]);
            }
        }
        return t[k][len-1];
    }

    private int solve(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock4 bestTimeToBuyAndSellStock4 = new BestTimeToBuyAndSellStock4();
        System.out.println(bestTimeToBuyAndSellStock4.maxProfit(2, new int[]{2,4,1}));//Output: 2
        System.out.println(bestTimeToBuyAndSellStock4.maxProfit(2, new int[]{3,2,6,5,0,3}));//Output: 7
    }
}
