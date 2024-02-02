package main.java.com.leetcode._698;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(k <= 0 || sum % k != 0){
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, sum/k);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int target) {
        if(k == 1){
            return true;
        }
        if(curSum == target){
            return canPartition(nums, visited, 0, k-1, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(canPartition(nums, visited, i+1, k, curSum+nums[i],target)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets partitionToKEqualSumSubsets = new PartitionToKEqualSumSubsets();
        System.out.println(partitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));//Output: true
        System.out.println(partitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));//Output: false
        System.out.println(partitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));//Output: false
        System.out.println(partitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));//Expected false
    }
}
