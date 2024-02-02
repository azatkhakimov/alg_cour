package leetcode._1026;

import leetcode.common.models.TreeNode;

public class  MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int curMax, int curMin) {
        if(node == null){
            return curMax - curMin;
        }
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);
        return Math.max(left, right);
    }


    public static void main(String[] args) {

    }
}

