package leetcode._47;

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(results, new ArrayList<>(), nums, new boolean[nums.length]);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> tempList, int[] nums, boolean[] used) {
        if(tempList.size() == nums.length){
            results.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                used[i] =true;
                tempList.add(nums[i]);
                backtrack(results, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(new int[]{1,1,2}));//Output:[[1,1,2],[1,2,1],[2,1,1]]
        System.out.println(permutationsII.permuteUnique(new int[]{1,2,3}));//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
}
