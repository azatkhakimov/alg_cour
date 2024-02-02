package main.java.com.leetcode.array._1658;

public class MinimumOperationstoReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int maxLength = -1;
        int currentSum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            currentSum += nums[r];
            while (l <= r && currentSum > sum - x){
                currentSum -=nums[l++];
            }
            if(currentSum == sum - x){
                maxLength = Math.max(maxLength, r-l+1);
            }
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

    public static void main(String[] args) {
        MinimumOperationstoReduceXtoZero minimumOperationstoReduceXtoZero = new MinimumOperationstoReduceXtoZero();
        System.out.println(minimumOperationstoReduceXtoZero.minOperations(new int[]{1,1,4,2,3},  5));
    }
}
