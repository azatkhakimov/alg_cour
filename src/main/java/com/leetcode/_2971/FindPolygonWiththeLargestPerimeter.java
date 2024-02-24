package main.java.com.leetcode._2971;

import java.util.Arrays;

public class FindPolygonWiththeLargestPerimeter {


    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prevSum = 0;
        long ans = -1;
        for (int num : nums) {
            if(num < prevSum){
                ans = prevSum + num;
            }
            prevSum += num;
        }
        return ans;
    }
    public static void main(String[] args) {
        var f = new FindPolygonWiththeLargestPerimeter();
        System.out.println(f.largestPerimeter(new int[]{5,5,5}));//Output: 15
        System.out.println(f.largestPerimeter(new int[]{1,12,1,2,5,50,3}));//Output: 12
        System.out.println(f.largestPerimeter(new int[]{5,5,50}));//Output: -1
    }
}
