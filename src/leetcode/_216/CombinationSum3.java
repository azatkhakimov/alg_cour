package leetcode._216;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<>(), k, 1, n);
        return result;
    }

    private void combination(List<List<Integer>> result, ArrayList<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> list = new ArrayList<>(comb);
            result.add(list);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(result, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 7));//Output: [[1,2,4]]
        System.out.println(combinationSum3.combinationSum3(3,9));//Output: [[1,2,6],[1,3,5],[2,3,4]]
        System.out.println(combinationSum3.combinationSum3(4,1));//Output: []
    }
}