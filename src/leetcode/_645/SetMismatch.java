package leetcode._645;

import java.util.Arrays;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int num : nums) {
            if(nums[Math.abs(num)-1]<0){
                res[0] = Math.abs(num);
            }else {
                nums[Math.abs(num-1)] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                res[1] = i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SetMismatch setMismatch = new SetMismatch();
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1,2,2,4})));//Output: [2,3]
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1,1})));//Output: [1,2]
    }
}
