package main.java.com.leetcode._229;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int number1 =  nums[0];
        int number2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] == number1){
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] == number1){
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            }
        }
        if(count1 > len / 3){
            result.add(number1);
        }
        if(count2 > len / 3){
            result.add(number2);
        }
        return result;
    }


    public static void main(String[] args) {
        var m = new MajorityElementII();
        System.out.println(m.majorityElement(new int[]{3,2,3}));//Output: [3]
        System.out.println(m.majorityElement(new int[]{1}));//Output: [1]
        System.out.println(m.majorityElement(new int[]{1,2}));//Output: [1,2]
    }
}
