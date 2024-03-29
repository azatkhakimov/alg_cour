package main.java.com.leetcode._1544;

import java.util.Stack;

//https://leetcode.com/problems/make-the-string-great/solutions/781009/java-simple-solution-using-stack-explained/?orderBy=most_votes
public class MakeTheStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i)) == 32){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        char[] res = new char[stack.size()];
        int index = stack.size()-1;
        while (!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        return new String(res);
    }


    public static void main(String[] args) {
        MakeTheStringGreat makeTheStringGreat = new MakeTheStringGreat();
        System.out.println(makeTheStringGreat.makeGood("leEeetcode"));//Output: "main.java.com.leetcode"
        System.out.println(makeTheStringGreat.makeGood("abBAcC"));//Output: ""
    }
}
