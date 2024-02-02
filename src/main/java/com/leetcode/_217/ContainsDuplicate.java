package main.java.com.leetcode._217;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        if(nums == null || nums.length == 0){
            return false;
        }
        Set<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if(!integers.add(num)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4}));
    }
}
