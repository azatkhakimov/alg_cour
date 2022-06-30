package leetcode.array;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
       int sum = 0;
       for(int num : nums){
           sum += num;
       }

       int n = nums.length+1;
       return (n*(n-1)/2)-sum;
    }
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int number = missingNumber.missingNumber(new int[]{0,1});
        System.out.println(number);
    }
}
