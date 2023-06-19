package leetcode._1161;

import leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTreeBFS {

    public int maxLevelSum(TreeNode root) {
        int ans = 0;
        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int currLevelSum = 0;
            for (int i = queue.size() - 1; i > 0; i--) {
                TreeNode currNode = queue.poll();
                currLevelSum += currNode.val;
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            if (currLevelSum > maxSum) {
                maxSum = currLevelSum;
                ans = level;
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
