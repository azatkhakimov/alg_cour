package leetcode.tree._114;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        System.out.println("root "+ root);
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }

            if(!stack.isEmpty()){
                cur.right = stack.peek();
            }

            cur.left = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        test.flatten(root);

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

     @Override
     public String toString() {
         return "TreeNode{" +
                 "val=" + val +
                 ", left=" + left +
                 ", right=" + right +
                 '}';
     }
 }

