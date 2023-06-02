package leetcode._124;

import leetcode.common.models.TreeNode;

public class BinaryTreeMaximumPathSum {
    int maxSumPath;
    public int maxPathSum(TreeNode root) {
        maxSumPath = Integer.MIN_VALUE;
        maxPath(root);
        return maxSumPath;
    }

    private int maxPath(TreeNode node) {
        if(node == null){
            return 0;
        }
        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0,maxPath(node.right));
        maxSumPath = Math.max(maxSumPath, left+right+node.val);
        return Math.max(left, right)+node.val;
    }
}
