package main.java.com.leetcode._1161;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumLevelSumofaBinaryTreeDFS {

    public int maxLevelSum(TreeNode root) {
        List<Integer> sumOfLevels = new ArrayList<>();
        dfs(root, 0, sumOfLevels);

        int answer = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < sumOfLevels.size(); i++) {
            Integer currVal = sumOfLevels.get(i);
            if (maxSum < currVal) {
                maxSum = currVal;
                answer = i + 1;
            }
        }
        return answer;

    }

    void dfs(TreeNode node, int level, List<Integer> sumOfLevels) {
        if (node == null) {
            return;
        }

        if (sumOfLevels.size() == level) {
            sumOfLevels.add(node.val);
        } else {
            sumOfLevels.set(level, sumOfLevels.get(level) + node.val);
        }
        dfs(node.left, level + 1, sumOfLevels);
        dfs(node.right, level + 1, sumOfLevels);
    }


    public static void main(String[] args) {
        var m = new MaximumLevelSumofaBinaryTreeDFS();
    }
}
