package main.java.com.leetcode._1464;

import java.util.Arrays;

public class MaximumProductofTwoElementsinanArray {


    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int x = nums[nums.length-1];
        int y = nums[nums.length-2];
        return (x-1)*(y-1);
    }
    public static void main(String[] args) {
        var m = new MaximumProductofTwoElementsinanArray();
        System.out.println(m.maxProduct(new int[]{3,4,5,2}));//Output: 12
        System.out.println(m.maxProduct(new int[]{1,5,4,5}));//Output: 16
        System.out.println(m.maxProduct(new int[]{3,7}));//Output: 12
    }
}
