package leetcode._814;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode node) {
        if(node == null){
            return false;
        }
        boolean leftContainsOne = containsOne(node.left);
        boolean rightsContainsOne = containsOne(node.right);
        if(!leftContainsOne){
            node.left = null;
        }
        if(!rightsContainsOne){
            node.right = null;
        }
        return node.val == 1 || leftContainsOne || rightsContainsOne;
    }

    public static void main(String[] args) {
        BinaryTreePruning binaryTreePruning = new BinaryTreePruning();

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
