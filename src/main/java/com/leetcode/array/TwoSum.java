package main.java.com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if(res.containsKey(search)){
                return new int[]{res.get(search), i};
            }
            res.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15}, 9)));//Output: [0,1]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,2,4}, 6)));//Output: [1,2]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,3}, 6)));//3,3
    }
}
