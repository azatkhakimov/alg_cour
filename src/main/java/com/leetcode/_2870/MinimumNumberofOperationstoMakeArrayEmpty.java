package main.java.com.leetcode._2870;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofOperationstoMakeArrayEmpty {

    public int minOperations(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Integer c : counter.values()) {
            if (c == 1) {
                return -1;
            }
            ans += Math.ceil((double) c / 3);
        }
        return ans;
    }

    public static void main(String[] args) {
        var m = new MinimumNumberofOperationstoMakeArrayEmpty();
        System.out.println(m.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));//Output: 4
        System.out.println(m.minOperations(new int[]{2, 1, 2, 2, 3, 3}));//Output: -1
    }
}
