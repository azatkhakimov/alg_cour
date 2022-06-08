package leetcode.backtracking._78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(answers, new ArrayList<Integer>(), nums, 0);
        return answers;
    }

    private void backtrack(List<List<Integer>> answers, ArrayList<Integer> tempList, int[] nums, int start) {
        answers.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(answers, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }

}
