package leetcode._1457;
//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/
public class PseudoPalindromicPathsInaBinaryTree {
    private int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode node, int path) {
        if(node == null){
            return;
        }
        path = path ^ (1 << node.val);
        if(node.left == null && node.right == null){
            if((path & (path-1))==0){
                count++;
            }
        }
        preorder(node.left, path);
        preorder(node.right, path);
    }

    public static void main(String[] args) {
        PseudoPalindromicPathsInaBinaryTree pseudoPalindromicPathsInaBinaryTree = new PseudoPalindromicPathsInaBinaryTree();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}