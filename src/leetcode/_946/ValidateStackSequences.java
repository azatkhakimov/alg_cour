package leetcode._946;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences v = new ValidateStackSequences();
        System.out.println(v.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));//Output: true
        System.out.println(v.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,3,5,1,2}));//Output: false
    }
}
