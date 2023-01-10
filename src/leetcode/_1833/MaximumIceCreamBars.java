package leetcode._1833;

import java.util.Arrays;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        if(costs[0] > coins){
            return count;
        }
        for (int cost : costs) {
            if(coins <= 0 || coins < cost){
                return count;
            }
            coins -= cost;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumIceCreamBars bars = new MaximumIceCreamBars();
        System.out.println(bars.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));//Output: 4
        System.out.println(bars.maxIceCream(new int[]{10,6,8,7,7,8}, 5));//Output: 0
        System.out.println(bars.maxIceCream(new int[]{1,6,3,1,2,5}, 20));//Output: 6
        System.out.println(bars.maxIceCream(new int[]{7,3,3,6,6,6,10,5,9,2}, 56));//9
    }
}
