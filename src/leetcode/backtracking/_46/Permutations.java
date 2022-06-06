package leetcode.backtracking._46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        backtrack(answers, new ArrayList<>(), nums);
        return answers;
    }

    private void backtrack(List<List<Integer>> answers, ArrayList<Integer> temp, int[] nums) {
        if(temp.size() == nums.length){
            answers.add(new ArrayList<>(temp));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                backtrack(answers, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1,2,3}));
    }
}
