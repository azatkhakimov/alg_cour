package main.java.com.leetcode._456;

import java.util.Stack;

public class _132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }

        for (int j = nums.length-1; j >= 0; j--) {
            while (!stack.isEmpty() && stack.peek() <= min[j]){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() < nums[j]){
                return true;
            }
            stack.push(nums[j]);
        }
        return false;
    }


    public static void main(String[] args) {
        var p = new _132Pattern();
        System.out.println(p.find132pattern(new int[]{1,2,3,4}));//Output: false
        System.out.println(p.find132pattern(new int[]{3,1,4,2}));//Output: true
        System.out.println(p.find132pattern(new int[]{-1,3,2,0}));//Output: true
    }
}
