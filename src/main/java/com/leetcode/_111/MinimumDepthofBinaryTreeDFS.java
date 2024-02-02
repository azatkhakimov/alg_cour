package main.java.com.leetcode._111;

import main.java.com.leetcode.common.models.TreeNode;

public class MinimumDepthofBinaryTreeDFS {

    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1 + dfs(root.right);
        }
        if(root.right == null){
            return 1 + dfs(root.left);
        }
        return 1+Math.min(dfs(root.left), dfs(root.right));
    }
}
