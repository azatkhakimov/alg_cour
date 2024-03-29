package main.java.com.leetcode._337;

import main.java.com.leetcode.common.models.TreeNode;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] result = heist(root);
        return Math.max(result[0], result[1]);
    }

    private int[] heist(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftSubtree = heist(root.left);
        int[] rightSubtree = heist(root.right);
        int includeRoot = root.val + leftSubtree[1] + rightSubtree[1];
        int excludeRoot = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);
        return new int[]{includeRoot, excludeRoot};
    }

    public static void main(String[] args) {

    }
}
