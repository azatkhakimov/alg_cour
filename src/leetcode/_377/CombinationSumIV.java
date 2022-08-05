package leetcode._377;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] combination = new int[target+1];
        combination[0] = 1;
        for (int i = 1; i < combination.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0){
                    combination[i] += combination[i-nums[j]];
                }
            }
        }
        return combination[target];
    }

    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        System.out.println(combinationSumIV.combinationSum4(new int[]{1,2,3}, 4));//Output: 7
        System.out.println( combinationSumIV.combinationSum4(new int[]{9},  3));//Output: 0
    }
}
