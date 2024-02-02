package main.java.com.leetcode._98;


import main.java.com.leetcode.common.models.TreeNode;

public class ValidateBinarySearchTree {
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(validateBinarySearchTree.isValidBST(treeNode));
    }
}
