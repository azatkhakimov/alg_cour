package main.java.com.leetcode._2090;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);
        if (2 * k + 1 > n) {
            return averages;
        }

        long windowSum = 0;
        for (int i = 0; i < (2 * k + 1); i++) {
            windowSum += nums[i];
        }
        averages[k] = (int)(windowSum/(2*k+1));
        for (int i = (2 * k + 1); i < n; i++) {
            windowSum = windowSum - nums[i-(2*k+1)]+nums[i];
            averages[i-k]=(int)(windowSum/(2*k+1));
        }
        return averages;
    }


    public static void main(String[] args) {
        var k = new KRadiusSubarrayAverages();
        System.out.println(Arrays.toString(k.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));//Output: [-1,-1,-1,5,4,4,-1,-1,-1]
        System.out.println(Arrays.toString(k.getAverages(new int[]{100000}, 0)));//Output: [100000]
        System.out.println(Arrays.toString(k.getAverages(new int[]{8}, 100000)));//Output: [-1]
    }
}
