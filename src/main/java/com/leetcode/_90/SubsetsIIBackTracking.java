package main.java.com.leetcode._90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIIBackTracking {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int pos) {
        result.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(result, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        var s = new SubsetsIIBackTracking();
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(s.subsetsWithDup(new int[]{0}));//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    }
}
