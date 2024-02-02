package main.java.com.leetcode._617;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.Stack;

public class MergeTwoBinaryTrees {


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});
        while (!stack.isEmpty()) {
            TreeNode[] curr = stack.pop();
            if(curr[0] == null || curr[1] == null){
                continue;
            }
            curr[0].val += curr[1].val;
            if(curr[0].left == null){
                curr[0].left = curr[1].left;
            }else {
                stack.push(new TreeNode[]{curr[0].left, curr[1].left});
            }

            if(curr[0].right == null){
                curr[0].right = curr[1].right;
            }else {
                stack.push(new TreeNode[]{curr[0].right, curr[1].right});
            }
        }
        return root1;
    }

    public static void main(String[] args) {

    }
}
