package main.java.com.leetcode._605;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                boolean emptyLeft = (i == 0) || (flowerbed[i-1] == 0);
                boolean emptyRight = (i == flowerbed.length-1) || (flowerbed[i+1] == 0);

                if(emptyLeft && emptyRight){
                    flowerbed[i] = 1;
                    count++;
                    if(count >= n){
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }


    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));//Output: true
        System.out.println(c.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));//Output: false
    }
}
