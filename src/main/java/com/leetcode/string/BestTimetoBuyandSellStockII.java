package main.java.com.leetcode.string;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        int valey;
        int peak;
        while (i < prices.length - 1){
            while (i < prices.length - 1 && prices[i] >= prices[i+1]){
                i++;
            }
            valey = prices[i];
            while (i< prices.length - 1 && prices[i] <= prices[i+1]){
                i++;
            }
            peak = prices[i];
            maxProfit += peak - valey;

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
        System.out.println(test.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
