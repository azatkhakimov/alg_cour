package leetcode._918;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int sum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        for (int num : nums) {
            curMax = Math.max(curMax, 0)+num;
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin, 0)+num;
            minSum = Math.min(minSum, curMin);
            sum += num;
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum-minSum);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray circularSubarray = new MaximumSumCircularSubarray();
        System.out.println(circularSubarray.maxSubarraySumCircular(new int[]{1,-2,3,-2}));//Output: 3
        System.out.println(circularSubarray.maxSubarraySumCircular(new int[]{5,-3,5}));//Output: 10
        System.out.println(circularSubarray.maxSubarraySumCircular(new int[]{-3,-2,-3}));//Output: -2
    }
}
