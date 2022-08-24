package leetcode._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> comb  = new LinkedList<>();
        Arrays.sort(candidates);

        backtrack(candidates, comb, target, 0, result);
        return result;
    }

    private void backtrack(int[] candidates, LinkedList<Integer> comb,
                           Integer remain, Integer curr,
                           List<List<Integer>> results) {
        if(remain == 0){
            results.add(new ArrayList<>(comb));
            return;
        }

        for (int nextCur = curr; nextCur < candidates.length; nextCur++) {
            if(nextCur > curr && candidates[nextCur] == candidates[nextCur-1]){
                continue;
            }
            Integer pick = candidates[nextCur];
            if(remain-pick < 0){
                break;
            }
            comb.addLast(pick);
            backtrack(candidates, comb, remain-pick, nextCur+1, results);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));//Output:[[1,1,6],[1,2,5],[1,7],[2,6]]
        System.out.println(combinationSum2.combinationSum2(new int[]{2,5,2,1,2}, 5));//Output:[[1,2,2],[5]]
    }
}
