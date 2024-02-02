package main.java.com.leetcode._39;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=OyZFFqQtu98
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int i, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(i == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[i] <= target){
            ds.add(candidates[i]);
            findCombinations(i, candidates, target-candidates[i], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(i+1, candidates, target, ans, ds);
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7));//Output: [[2,2,3],[7]]
        System.out.println(combinationSum.combinationSum(new int[]{2,3,5}, 8));//Output: [[2,2,2,2],[2,3,3],[3,5]]
    }
}
