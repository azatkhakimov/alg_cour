package main.java.com.leetcode._659;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> availMap = new HashMap<>();
        Map<Integer, Integer> wantedMap = new HashMap<>();

        for (int num : nums) {
            availMap.put(num, availMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (availMap.get(nums[i]) <= 0) {
                continue;
            } else if (wantedMap.getOrDefault(nums[i], 0) > 0) {
                availMap.put(nums[i], availMap.getOrDefault(nums[i], 0) - 1);
                wantedMap.put(nums[i], wantedMap.getOrDefault(nums[i], 0) - 1);
                wantedMap.put(nums[i] + 1, wantedMap.getOrDefault(nums[i] + 1, 0) + 1);
            } else if (availMap.getOrDefault(nums[i], 0) > 0 && availMap.getOrDefault(nums[i] + 1, 0) > 0
                    && availMap.getOrDefault(nums[i] + 2, 0) > 0) {
                availMap.put(nums[i], availMap.getOrDefault(nums[i], 0) - 1);
                availMap.put(nums[i] + 1, availMap.getOrDefault(nums[i] + 1, 0) - 1);
                availMap.put(nums[i] + 2, availMap.getOrDefault(nums[i] + 2, 0) - 1);

                wantedMap.put(nums[i] + 3, wantedMap.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences test = new SplitArrayIntoConsecutiveSubsequences();
        System.out.println(test.isPossible(new int[]{1, 2, 3, 3, 4, 5}));//Output: true
        System.out.println(test.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));//Output: true
        System.out.println(test.isPossible(new int[]{1, 2, 3, 4, 4, 5}));//Output: false
    }
}
