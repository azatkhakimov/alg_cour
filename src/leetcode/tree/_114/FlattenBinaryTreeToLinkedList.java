package leetcode.tree._114;

import leetcode.common.models.TreeNode;

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
