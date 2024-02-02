package main.java.com.leetcode._219;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {

                return true;
            }
            map.put(nums[i], i);
        }
        return false;


    }

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        System.out.println(containsDuplicateII.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));//Output: true
        System.out.println(containsDuplicateII.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));//Output: true
        System.out.println(containsDuplicateII.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));//Output: false
    }
}
