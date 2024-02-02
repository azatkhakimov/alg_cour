package main.java.com.leetcode.array._665;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int changes = 0;

        for (int i = 1; i < nums.length && changes <=1; i++) {
            if(nums[i-1] > nums[i]){
                changes++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return changes <=1;
    }

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        System.out.println(nonDecreasingArray.checkPossibility(new int[]{4,2,3}));//Output: true
    }

}
