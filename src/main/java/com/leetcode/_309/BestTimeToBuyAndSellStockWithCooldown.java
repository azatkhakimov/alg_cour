package main.java.com.leetcode._309;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int hold = Integer.MIN_VALUE;
        int reset = 0;
        for (int price : prices) {
            int prevSold = sold;
            sold = hold + price;
            hold = Math.max(hold, reset - price);
            reset = Math.max(reset, prevSold);
        }
        return Math.max(sold, reset);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown seller = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(seller.maxProfit(new int[]{1,2,3,0,2}));//Output: 3 Explanation: transactions = [buy, sell, cooldown, buy, sell]
        System.out.println(seller.maxProfit(new int[]{1}));//Output: 0
    }
}
