package main.java.com.leetcode._2385;

import main.java.com.leetcode.common.models.TreeNode;

public class AmountofTimeforBinaryTreetoBeInfected {
    int maxDist = 0;

    public int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return maxDist;
    }

    private int traverse(TreeNode root, int start) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        int leftDepth = traverse(root.left, start);
        int rightDepth = traverse(root.right, start);

        if (root.val == start) {
            maxDist = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int dist = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDist = Math.max(maxDist, dist);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
