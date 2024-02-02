package main.java.com.leetcode._2369;

public class CheckifThereisaValidPartitionForTheArray {


    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int dpIndex = i+1;
            if(i > 0 && nums[i] == nums[i-1]){
                dp[dpIndex] |= dp[dpIndex-2];
            }
            if(i > 1 && nums[i] == nums[i-1] && nums[i] == nums[i-2]){
                dp[dpIndex] |= dp[dpIndex-3];
            }
            if(i > 1 && nums[i] == nums[i-1]+1 && nums[i]==nums[i-2]+2){
                dp[dpIndex] |= dp[dpIndex-3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        var c = new CheckifThereisaValidPartitionForTheArray();
        System.out.println(c.validPartition(new int[]{4,4,4,5,6}));//Output: true
        System.out.println(c.validPartition(new int[]{1,1,1,2}));//Output: false
    }
}
