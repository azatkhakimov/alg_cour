package leetcode._121;

/*
* 121. Best Time to Buy and Sell Stock
* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
* Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.*/
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int buy =  0;
        int sell = 1;
        int maxProfit = 0;
        while (sell < prices.length){
            int currentProfit = prices[sell] - prices[buy];
            if(prices[buy] < prices[sell]){
                maxProfit = Math.max(maxProfit, currentProfit);
            }else {
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeBuySellStock b = new BestTimeBuySellStock();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4}));//Output: 5
        System.out.println(b.maxProfit(new int[]{7,6,4,3,1}));//Output: 0
    }
}
