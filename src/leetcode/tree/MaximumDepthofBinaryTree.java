package leetcode.tree;

public class MaximumDepthofBinaryTree {
    private int answer = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return answer;
        }
        maxDepth(root, answer+1);
        return answer;
    }

    public void maxDepth(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            answer = Math.max(answer, depth);
        }
        maxDepth(root.left, depth+1);
        maxDepth(root.right, depth+1);
    }
}
