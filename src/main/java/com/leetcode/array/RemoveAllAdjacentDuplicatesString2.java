package main.java.com.leetcode.array;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesString2 {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().c == c){
                stack.peek().count++;
            }else {
                stack.push(new Node(c, 1));
            }
            if(stack.peek().count == k){
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Node node : stack) {
            for(int i =0; i < node.count; i++){
                sb.append(node.c);
            }
        }
        return sb.toString();
    }

    private class Node {
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesString2 test = new RemoveAllAdjacentDuplicatesString2();
        System.out.println(test.removeDuplicates("abcd", 2));
        System.out.println(test.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
