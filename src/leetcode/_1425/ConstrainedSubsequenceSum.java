package leetcode._1425;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class ConstrainedSubsequenceSum {


    public int constrainedSubsetSum(int[] nums, int k) {
        TreeMap<Integer, Integer> window = new TreeMap<>();
        window.put(0,0);
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i] + window.lastKey();
            window.put(dp[i], window.getOrDefault(dp[i],0)+1);

            if(i >= k){
                window.put(dp[i-k], window.get(dp[i-k])-1);
                if(window.get(dp[i-k])== 0){
                    window.remove(dp[i-k]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int num : dp) {
            ans = Math.max(ans, num);
        }
        return ans;
    }


    public static void main(String[] args) {
        var c = new ConstrainedSubsequenceSum();
        System.out.println(c.constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2));//Output: 37
        System.out.println(c.constrainedSubsetSum(new int[]{-1,-2,-3}, 1));//Output: -1
        System.out.println(c.constrainedSubsetSum(new int[]{10,-2,-10,-5,20}, 2));//Output: 23
    }
}
