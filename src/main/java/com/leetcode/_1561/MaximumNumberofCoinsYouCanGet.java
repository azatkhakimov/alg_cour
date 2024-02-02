package main.java.com.leetcode._1561;

import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {


    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for (int i = piles.length / 3; i < piles.length; i+=2) {
            ans += piles[i];
        }
        return ans;
    }



    public static void main(String[] args) {
        var m = new MaximumNumberofCoinsYouCanGet();
        System.out.println(m.maxCoins(new int[]{2,4,1,2,7,8}));//Output: 9
        System.out.println(m.maxCoins(new int[]{2,4,5}));//Output: 4
        System.out.println(m.maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));//Output: 18
    }
}
