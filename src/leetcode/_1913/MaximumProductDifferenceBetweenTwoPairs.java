package leetcode._1913;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1]*nums[nums.length-2] - nums[0]*nums[1];
    }

    public static void main(String[] args) {
        var m = new MaximumProductDifferenceBetweenTwoPairs();
        System.out.println(m.maxProductDifference(new int[]{5,6,2,7,4}));//Output: 34
        System.out.println(m.maxProductDifference(new int[]{4,2,5,9,7,4,8}));//Output: 64
    }
}
