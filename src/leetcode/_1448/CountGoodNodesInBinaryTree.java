package leetcode._1448;

import leetcode.common.models.TreeNode;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val >= max){
            max = root.val;
            count++;
        }
        return count + (dfs(root.left, max) + dfs(root.right, max));
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree countGoodNodesInBinaryTree = new CountGoodNodesInBinaryTree();
    }
}
