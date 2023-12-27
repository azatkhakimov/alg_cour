package leetcode._2706;

import java.util.Arrays;

public class BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int minCost = prices[0] + prices[1];
        if (money >= minCost) {
            return money - minCost;
        }
        return money;
    }

    public static void main(String[] args) {
        var b = new BuyTwoChocolates();
        System.out.println(b.buyChoco(new int[]{1, 2, 2}, 3));//Output: 0
        System.out.println(b.buyChoco(new int[]{3, 2, 3}, 3));//Output: 3
    }
}
