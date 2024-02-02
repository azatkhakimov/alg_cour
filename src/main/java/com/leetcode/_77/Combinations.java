package main.java.com.leetcode._77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> comb, int start, int n, int k) {
        if(k == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(res, comb, i+1, n,k-1);
            comb.remove(comb.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4,2));//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println(combinations.combine(1,1));//Output: [[1]]
    }
}
