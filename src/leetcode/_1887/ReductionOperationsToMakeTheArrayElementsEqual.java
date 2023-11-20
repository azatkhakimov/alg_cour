package leetcode._1887;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual {


    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int up = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                up++;
            }
            ans += up;
        }
        return ans;
    }

    public static void main(String[] args) {
        var r = new ReductionOperationsToMakeTheArrayElementsEqual();
        System.out.println(r.reductionOperations(new int[]{5, 1, 3}));//Output: 3
        System.out.println(r.reductionOperations(new int[]{1, 1, 1}));//Output: 0
        System.out.println(r.reductionOperations(new int[]{1, 1, 2, 2, 3}));//Output: 4
    }
}
