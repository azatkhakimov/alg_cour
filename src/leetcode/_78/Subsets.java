package leetcode._78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(int start, List<Integer>temp, int[] nums) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(i+1, temp, nums);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    }

}
