package main.java.com.leetcode._1431;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        List<Boolean> ans = new ArrayList<>();
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            ans.add(candy+extraCandies >= max);
        }
        return ans;
    }


    public static void main(String[] args) {
        KidsWiththeGreatestNumberofCandies k  = new KidsWiththeGreatestNumberofCandies();
        System.out.println(k.kidsWithCandies(new int[]{2,3,5,1,3}, 3));//Output: [true,true,true,false,true]
        System.out.println(k.kidsWithCandies(new int[]{4,2,1,1,2}, 1));//Output: [true,false,false,false,false]
        System.out.println(k.kidsWithCandies(new int[]{12,1,12}, 10));//Output: [true,false,true]
    }
}
