package main.java.com.leetcode._905;

import java.util.Arrays;

public class SortArrayByParity {


    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if(nums[j] % 2 == 0){
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        var s = new SortArrayByParity();
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3,1,2,4})));//Output: [2,4,3,1]
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{0})));//Output: [0]
    }
}
