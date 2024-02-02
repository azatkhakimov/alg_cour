package main.java.com.leetcode._977;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        for (int i = result.length - 1; i >= 0; i--) {
            if(Math.abs(nums[left]) > nums[right]){
                result[i] = nums[left]*nums[left];
                left++;
            }else {
                result[i] = nums[right]*nums[right];
                right--;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        System.out.println(Arrays.toString(squaresOfSortedArray.sortedSquares(new int[]{-4,-1,0,3,10})));//Output: [0,1,9,16,100]
        System.out.println(Arrays.toString(squaresOfSortedArray.sortedSquares(new int[]{-7,-3,2,3,11})));//Output: [4,9,9,49,121]
    }
}
