package leetcode.array._135;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] leftRel = new int[ratings.length];
        int[] rightRel = new int[ratings.length];
        Arrays.fill(leftRel, 1);
        Arrays.fill(rightRel, 1);
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                leftRel[i] = leftRel[i] + leftRel[i-1];
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]){
                rightRel[i] = rightRel[i] + rightRel[i+1];
            }
        }
        int candies = 0;
        for (int i = 0; i < ratings.length; i++) {
            candies = candies + Math.max(leftRel[i], rightRel[i]);
        }

        return candies;
    }
    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.candy(new int[]{1,0,2}));//Output: 5
        System.out.println(candy.candy(new int[]{1,2,2}));//Output: 4
    }
}
