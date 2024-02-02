package main.java.com.leetcode._2265;

import main.java.com.leetcode.common.models.TreeNode;

public class CountNodesEqualtoAverageofSubtree {
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    private int[] postOrder(TreeNode root) {
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        int nodeSum = left[0] + right[0] + root.val;
        int nodeCount = left[1] + right[1] +1;

        if(root.val == nodeSum / (nodeCount)){
            count++;
        }

        return new int[]{nodeSum, nodeCount};
    }

    public static void main(String[] args) {
        var c = new CountNodesEqualtoAverageofSubtree();
        //System.out.println(c.averageOfSubtree());
    }
}
