package leetcode._209;

import java.util.Arrays;
import java.util.Map;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int windowSize = Integer.MAX_VALUE;
        int currArrSize = 0;
        int start = 0;
        int totalSum = 0;
        for (int end = 0; end < nums.length; end++) {
            totalSum += nums[end];
            while (totalSum >= target){
                currArrSize = (end+1)-start;
                windowSize = Math.min(windowSize, currArrSize);
                totalSum -= nums[start];
                start++;
            }
        }
        if(windowSize != Integer.MAX_VALUE){
            return windowSize;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum subarray = new MinimumSizeSubarraySum();
        System.out.println(subarray.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));//Output: 2
        System.out.println(subarray.minSubArrayLen(4, new int[]{1,4,4}));//Output: 1
        System.out.println(subarray.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));//Output: 0
        System.out.println(subarray.minSubArrayLen(20, new int[]{2,16,14,15}));//2
    }
}
