package leetcode._46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        backtrack(answers, new ArrayList<>(), nums);
        return answers;
    }

    private void backtrack(List<List<Integer>> answers, ArrayList<Integer> temp, int[] nums) {
        if(nums.length == temp.size()){
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
        System.out.println(permutations.permute(new int[]{1,2,3}));//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(permutations.permute(new int[]{0,1}));//Output: [[0,1],[1,0]]
        System.out.println(permutations.permute(new int[]{1}));//Output: [[1]]
    }
}
