package main.java.com.leetcode._2966;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length/3][3];
        for(int i = 0; i < nums.length; i+=3){
            if(nums[i+2]-nums[i] > k){
                return new int[0][0];
            }
            ans[i/3] = new int[]{nums[i], nums[i+1], nums[i+2]};
        }
        return ans;
    }

    public static void main(String[] args) {
        var d = new DivideArrayIntoArraysWithMaxDifference();
        System.out.println(Arrays.deepToString(d.divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2)));//Output: [[1,1,3],[3,4,5],[7,8,9]]
        System.out.println(Arrays.deepToString(d.divideArray(new int[]{1,3,3,2,7,3}, 3)));//Output: []
    }
}
