package main.java.com.leetcode._1512;

import java.util.HashMap;
import java.util.Map;

public class NumberofGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            ans += counts.getOrDefault(num, 0);
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberofGoodPairs n = new NumberofGoodPairs();
        System.out.println(n.numIdenticalPairs(new int[]{1,2,3,1,1,3}));//Output: 4
        System.out.println(n.numIdenticalPairs(new int[]{1,1,1,1}));//Output: 6
        System.out.println(n.numIdenticalPairs(new int[]{1,2,3}));//Output: 0
    }
}
