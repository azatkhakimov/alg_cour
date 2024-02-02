package main.java.com.leetcode.tree._968;

import main.java.com.leetcode.common.models.TreeNode;

public class BinaryTreeCameras {
    public int minCameraCover(TreeNode root) {
        int [] ans = solve(root);
        return Math.min(ans[1], ans[2]);

    }

    private int[] solve(TreeNode node) {
        if(node == null){
            return new int[]{0, 0, 99999};
        }
        int[] left = solve(node.left);
        int[] right = solve(node.right);
        int mL12 = Math.min(left[1], left[2]);
        int mR12 = Math.min(right[1], right[2]);

        int d0 = left[1]+right[1];
        int d1 = Math.min(left[2]+mR12, right[2]+mL12);
        int d2 = 1+ Math.min(left[0], mL12) + Math.min(right[0], mR12);

        return new int[]{d0, d1, d2};
    }
}
