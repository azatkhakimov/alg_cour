package main.java.com.leetcode._416;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if(total % 2 != 0){
            return false;
        }
        total /= 2;
        boolean[] dp = new boolean[total+1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = total; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[total];
    }



    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,5,11,5}));//Output: true
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,2,3,5}));//Output: false
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,2,5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{5,79,2,4,8,16,32,64,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100}));
    }
}
