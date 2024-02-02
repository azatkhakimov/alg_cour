package main.java.com.leetcode._976;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            if(nums[i] + nums[i+1] > nums[i+2]){
                return nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle largestPerimeterTriangle = new LargestPerimeterTriangle();
        System.out.println(largestPerimeterTriangle.largestPerimeter(new int[]{2,1,2}));//Output: 5
        System.out.println(largestPerimeterTriangle.largestPerimeter(new int[]{1,2,1}));//Output: 0
    }
}
