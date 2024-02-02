package main.java.com.leetcode._2215;

import java.util.*;

public class FindtheDifferenceofTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(helper(nums1, nums2), helper(nums2, nums1));
    }

    private List<Integer> helper(int[] nums1, int[] nums2) {
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            if(!set2.contains(num)){
                set1.add(num);
            }
        }
        return new ArrayList<>(set1);
    }

    public static void main(String[] args) {
        FindtheDifferenceofTwoArrays f = new FindtheDifferenceofTwoArrays();
        System.out.println(f.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));//Output: [[1,3],[4,6]]
        System.out.println(f.findDifference(new int[]{1,2,3,3}, new int[] {1,1,2,2}));//Output: [[3],[]]
    }
}
