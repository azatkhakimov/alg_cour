package main.java.com.leetcode._1361;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1){
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        seen.add(root);
        stack.push(root);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            int[] children = {leftChild[node], rightChild[node]};
            for (int child : children) {
                if(child != -1){
                    if(seen.contains(child)){
                        return false;
                    }
                    stack.push(child);
                    seen.add(child);
                }
            }
        }
        return seen.size() == n;
    }

    private int findRoot(int n, int[] leftChild, int[] rightChild){
        Set<Integer> children = new HashSet<>();
        for (int node : leftChild) {
            children.add(node);
        }

        for (int node : rightChild) {
            children.add(node);
        }

        for (int i = 0; i < n; i++) {
            if(!children.contains(i)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        var v = new ValidateBinaryTreeNodes();
        System.out.println(v.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));//Output: true
        System.out.println(v.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1}));//Output: false
        System.out.println(v.validateBinaryTreeNodes(2, new int[]{1,0}, new int[]{-1,-1}));//Output: false
    }
}
