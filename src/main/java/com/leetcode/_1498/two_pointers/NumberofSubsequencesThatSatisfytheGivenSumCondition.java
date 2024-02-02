package main.java.com.leetcode._1498.two_pointers;

import java.util.Arrays;


public class NumberofSubsequencesThatSatisfytheGivenSumCondition {

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i-1]*2)%mod;
        }
        int answer = 0;
        int left = 0;
        int right = n-1;
        while (left <= right){
            if(nums[left]+nums[right] <= target){
                answer += power[right-left];
                answer %= mod;
                left++;
            }else {
                right--;
            }
        }
        return answer;

    }



    public static void main(String[] args) {
        var n = new NumberofSubsequencesThatSatisfytheGivenSumCondition();
        System.out.println(n.numSubseq(new int[]{3, 5, 6, 7}, 9));//Output: 4
        System.out.println(n.numSubseq(new int[]{3, 3, 6, 8}, 10));//Output: 6
        System.out.println(n.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));//Output: 61
        System.out.println(n.numSubseq(new int[]{3,5,6,6,9,10,12,14}, 17));
    }
}
