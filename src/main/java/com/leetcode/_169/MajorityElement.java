package main.java.com.leetcode._169;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int result = 0;
        int vote = 0;
        for (int num : nums) {
            if(vote == 0){
                result = num;
            }

            if (result == num){
                vote += 1;
            }else {
                vote -= 1;
            }
        }
        return result;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        var m = new MajorityElement();
        System.out.println(m.majorityElement(new int[]{3,2,3}));//Output: 3
        System.out.println(m.majorityElement(new int[]{2,2,1,1,1,2,2}));//Output: 2
        System.out.println(m.majorityElement2(new int[]{3,2,3}));//Output: 3
        System.out.println(m.majorityElement2(new int[]{2,2,1,1,1,2,2}));//Output: 2
    }
}
