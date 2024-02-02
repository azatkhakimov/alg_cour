package main.java.com.leetcode._1493;

public class LongestSubarrayof1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int maxWindow = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
            while (zeroCount > 1){
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            maxWindow = Math.max(maxWindow, i-start);
        }
        return maxWindow;
    }

    public static void main(String[] args) {
        var l = new LongestSubarrayof1sAfterDeletingOneElement();
        System.out.println(l.longestSubarray(new int[]{1,1,0,1}));//Output: 3
        System.out.println(l.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));//Output: 5
        System.out.println(l.longestSubarray(new int[]{1,1,1}));//Output: 2
    }
}
