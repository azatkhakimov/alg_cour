package main.java.com.leetcode.array._1480;

import java.util.Arrays;

public class RunningSumof1dArray {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1]+nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        RunningSumof1dArray runningSumof1dArray = new RunningSumof1dArray();
        System.out.println(Arrays.toString(runningSumof1dArray.runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSumof1dArray.runningSum(new int[]{1,1,1,1,1})));
    }
}
