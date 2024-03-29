package main.java.com.leetcode._783;

import main.java.com.leetcode.common.models.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    int minDistance = Integer.MAX_VALUE;
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDistance;
    }

    private void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev != null){
            minDistance = Math.min(minDistance, root.val- prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}
