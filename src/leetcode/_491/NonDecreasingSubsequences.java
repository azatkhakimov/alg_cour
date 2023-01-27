package leetcode._491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> seq = new ArrayList<>();
        backtrack(nums, 0, seq, res);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, int index, List<Integer> seq, Set<List<Integer>> res) {
        if(index == nums.length){
            if(seq.size() >= 2){
                res.add(new ArrayList<>(seq));
            }
            return;
        }
        if(seq.isEmpty() || seq.get(seq.size()-1) <= nums[index]){
            seq.add(nums[index]);
            backtrack(nums, index+1, seq, res);
            seq.remove(seq.size()-1);
        }
        backtrack(nums, index+1, seq, res);
    }


    public static void main(String[] args) {
        NonDecreasingSubsequences subsequences = new NonDecreasingSubsequences();
        System.out.println(subsequences.findSubsequences(new int[]{4,6,7,7}));//[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        System.out.println(subsequences.findSubsequences(new int[]{4,4,3,2,1}));//[[4,4]]
    }
}
