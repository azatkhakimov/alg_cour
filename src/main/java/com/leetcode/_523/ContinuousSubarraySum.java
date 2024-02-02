package main.java.com.leetcode._523;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!map.containsKey(sum%k)){
                map.put(sum%k, i+1);
            }else if(map.get(sum%k) < i){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        System.out.println(continuousSubarraySum.checkSubarraySum(new int[]{23,2,4,6,7}, 6));//Output: true
        System.out.println(continuousSubarraySum.checkSubarraySum(new int[]{23,2,6,4,7}, 6));//Output: true
        System.out.println(continuousSubarraySum.checkSubarraySum(new int[]{23,2,6,4,7}, 13));//Output: false
    }
}
