package main.java.com.leetcode._1218;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceofGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1;
        for (int a : arr) {
            int k = a - difference;
            int beforeA = dp.getOrDefault(k, 0);
            dp.put(a, beforeA+1);
            answer = Math.max(answer, dp.get(a));
        }
        return answer;
    }

    public static void main(String[] args) {
        var l = new LongestArithmeticSubsequenceofGivenDifference();
        System.out.println(l.longestSubsequence(new int[]{1,2,3,4}, 1));//Output: 4
        System.out.println(l.longestSubsequence(new int[]{1,3,5,7}, 1));//Output: 1
        System.out.println(l.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));//Output: 4
        System.out.println(l.longestSubsequence(new int[]{1,5,7,3,-1,5,3,4,2,1}, -2));//Output: 4
    }
}
