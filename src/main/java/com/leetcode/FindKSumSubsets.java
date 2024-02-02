package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKSumSubsets {

    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<Integer>(), setOfIntegers, targetSum);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, ArrayList<Integer> curr, List<Integer> setOfIntegers, int targetSum) {
        if(curr.size() == setOfIntegers.size()){
            ans.add(new ArrayList<>(curr));
        }

    }

    public static void main(String[] args) {

    }
}
