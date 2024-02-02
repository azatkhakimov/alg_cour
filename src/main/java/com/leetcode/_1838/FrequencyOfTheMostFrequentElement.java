package main.java.com.leetcode._1838;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        long curr = 0;

        for (int right = 0; right < nums.length; right++) {
            int target = nums[right];
            curr += target;
            while ((right-left+1) * target - curr > k){
                curr -= nums[left];
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        var f = new FrequencyOfTheMostFrequentElement();
        System.out.println(f.maxFrequency(new int[]{1,2,4}, 5));//Output: 3
        System.out.println(f.maxFrequency(new int[]{1,4,8,13}, 5));//Output: 2
        System.out.println(f.maxFrequency(new int[]{3,9,6}, 2));//Output: 1
    }
}
