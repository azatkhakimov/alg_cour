package main.java.com.leetcode._875;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while (left < right){
            int k = left + (right-left)/2;
            int total = 0;
            for (int pile : piles) {
                total += (pile+k-1)/k;
            }
            if(total > h){
                left = k+1;
            }else {
                right = k;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas k = new KokoEatingBananas();
        System.out.println(k.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));//Output: 4
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 5));//Output: 30
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 6));//Output: 23
    }
}
