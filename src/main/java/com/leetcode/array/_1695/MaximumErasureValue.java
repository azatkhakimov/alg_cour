package main.java.com.leetcode.array._1695;


import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int ans = 0;
        int i = 0;
        int j = 0;

        while (i < nums.length && j < nums.length){
            if(!set.contains(nums[j])){
                sum+=nums[j];
                ans = Math.max(sum, ans);
                set.add(nums[j++]);
            }else {
                sum = sum-nums[i];
                set.remove(nums[i++]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    }
}
