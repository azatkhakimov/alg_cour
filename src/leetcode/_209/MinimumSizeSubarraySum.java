package leetcode._209;

import java.util.Arrays;
import java.util.Map;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
       int n = nums.length;
       int ans = Integer.MAX_VALUE;
       int left = 0;
       int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target){
                ans = Math.min(ans, i+1-left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum subarray = new MinimumSizeSubarraySum();
        System.out.println(subarray.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));//Output: 2
        System.out.println(subarray.minSubArrayLen(4, new int[]{1,4,4}));//Output: 1
        System.out.println(subarray.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));//Output: 0
        System.out.println(subarray.minSubArrayLen(20, new int[]{2,16,14,15}));//2
    }
}
