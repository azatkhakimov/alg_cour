package main.java.com.leetcode._1877;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {


    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < nums.length/2; i++) {
            maxSum = Math.max(nums[i] + nums[nums.length-1-i], maxSum);
        }
        return maxSum;

    }
    public static void main(String[] args) {
        var m = new MinimizeMaximumPairSumInArray();
        System.out.println(m.minPairSum(new int[]{3,5,2,3}));//Output: 7
        System.out.println(m.minPairSum(new int[]{3,5,4,2,4,6}));//Output: 8
    }
}
