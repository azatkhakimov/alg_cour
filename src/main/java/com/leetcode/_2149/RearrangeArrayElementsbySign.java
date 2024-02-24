package main.java.com.leetcode._2149;

import java.util.Arrays;

public class RearrangeArrayElementsbySign {

    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIdx = 0;
        int negIdx = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIdx] = nums[i];
                posIdx += 2;
            } else {
                ans[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var r = new RearrangeArrayElementsbySign();
        System.out.println(Arrays.toString(r.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));//Output: [3,-2,1,-5,2,-4]
        System.out.println(Arrays.toString(r.rearrangeArray(new int[]{-1, 1})));//Output: [1,-1]
    }
}
