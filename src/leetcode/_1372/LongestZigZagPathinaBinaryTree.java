package leetcode._1372;

import leetcode.common.models.TreeNode;

public class LongestZigZagPathinaBinaryTree {
    int pathLength =  0;
    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return pathLength;
    }
    private void dfs(TreeNode node, boolean left, int steps){
        if(node == null){
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if(left){
            dfs(node.left, false, steps+1);
            dfs(node.right, true, 1);
        }else{
            dfs(node.left, false, 1);
            dfs(node.right, true, steps+1);
        }
    }

    public static void main(String[] args) {

    }

}
