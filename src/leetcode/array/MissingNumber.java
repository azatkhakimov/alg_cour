package leetcode.array;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums.length == 2){
            return 2;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int number = missingNumber.missingNumber(new int[]{0,1});
        System.out.println(number);
    }
}
