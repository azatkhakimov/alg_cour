package main.java.com.leetcode.array;

import java.util.Stack;

public class Pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3){
            return  false;
        }
        Stack<Integer> stack = new Stack<>();
         int [] min = new int[nums.length];
         min[0] = nums[0];
         for(int i = 1; i < nums.length; i++){
             min[i] = Math.min(min[i-1], nums[i]);
         }
         for(int j = nums.length-1; j>=0; j--){
             if(nums[j] > min[j]){
                 while (!stack.isEmpty() && stack.peek() <= min[j]){
                     stack.pop();
                 }
                 if(!stack.isEmpty() && stack.peek() < nums[j]){
                     return true;
                 }
                 stack.push(nums[j]);
             }
         }
         return false;
    }



    public static void main(String[] args) {
        Pattern pattern = new Pattern();
        System.out.println(pattern.find132pattern(new int[]{-1,3,2,0}));
    }
}
