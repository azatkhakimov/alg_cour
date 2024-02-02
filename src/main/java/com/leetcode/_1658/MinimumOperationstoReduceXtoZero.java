package main.java.com.leetcode._1658;

public class MinimumOperationstoReduceXtoZero {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int maxLength = -1;
        int currSum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (l <= r && currSum > sum-x){
                currSum -= nums[l++];
            }
            if(currSum == sum - x){
                maxLength = Math.max(maxLength, r-l+1);

            }
        }

        return maxLength == -1 ? -1 : nums.length-maxLength;
    }


    public static void main(String[] args) {
        var m = new MinimumOperationstoReduceXtoZero();
        System.out.println(m.minOperations(new int[]{1, 1, 4, 2, 3}, 5));//Output: 2
        System.out.println(m.minOperations(new int[]{5, 6, 7, 8, 9}, 4));//Output: -1
        System.out.println(m.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));//Output: 5
    }
}
