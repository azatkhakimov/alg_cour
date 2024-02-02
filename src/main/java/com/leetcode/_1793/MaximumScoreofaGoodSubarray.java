package main.java.com.leetcode._1793;

import java.util.ArrayList;
import java.util.List;

public class MaximumScoreofaGoodSubarray {


    public int maximumScore(int[] nums, int k) {
        int ans = solve(nums, k);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
        return Math.max(ans, solve(nums, nums.length-k-1));
    }

    private int solve(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[k];
        int currMin = Integer.MAX_VALUE;
        for (int i = k - 1; i >= 0; i--) {
            currMin = Math.min(currMin, nums[i]);
            left[i] = currMin;
        }
        List<Integer> right = new ArrayList<>();
        currMin = Integer.MAX_VALUE;
        for (int i = k; i < n; i++) {
            currMin = Math.min(currMin, nums[i]);
            right.add(currMin);
        }
        int ans = 0;
        for (int j = 0; j < right.size(); j++) {
            currMin = right.get(j);
            int i = binarySearch(left, currMin);
            int size = (k + j) - i + 1;
            ans = Math.max(ans, currMin * size);
        }
        return ans;
    }

    private int binarySearch(int[] nums, int num) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var m = new MaximumScoreofaGoodSubarray();
        System.out.println(m.maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));//Output: 15
        System.out.println(m.maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));//Output: 20
    }
}
