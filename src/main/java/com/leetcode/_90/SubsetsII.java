package main.java.com.leetcode._90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        result.add(new ArrayList<>());
        subset(0, nums, numList, result, true);
        return result;
    }

    private void subset(int offset, int[] nums, List<Integer> numList, List<List<Integer>> result, boolean isPicked) {
        if(offset >= nums.length){
            return;
        }
        int val = nums[offset];
        if(offset == 0 || nums[offset-1] != nums[offset] || isPicked){
            numList.add(val);
            subset(offset+1, nums, numList, result, true);
            result.add(new ArrayList<>(numList));
            numList.remove(numList.size()-1);
        }
        subset(offset+1, nums, numList, result, false);
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(new int[]{1,2,2}));//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(subsetsII.subsetsWithDup(new int[]{0}));//Output: [[],[0]]
    }
}
