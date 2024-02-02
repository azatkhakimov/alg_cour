package main.java.com.leetcode._714;

public class BestTimetoBuyandSellStockwithTransactionFee {


    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] free = new int[n];
        hold[0] = - prices[0];
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i-1], free[i-1]-prices[i]);
            free[i] = Math.max(free[i-1], hold[i-1]+prices[i]-fee);
        }
        return free[n-1];
    }

    public static void main(String[] args) {
        var b = new BestTimetoBuyandSellStockwithTransactionFee();
        System.out.println(b.maxProfit(new int[]{1,3,2,8,4,9}, 2));//Output: 8
        System.out.println(b.maxProfit(new int[]{1,3,7,5,10,3}, 3));//Output: 6
    }
}
