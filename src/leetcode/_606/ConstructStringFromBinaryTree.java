package leetcode._606;

import leetcode.common.models.TreeNode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }
        if(root.left == null && root.right == null){
            return root.val+"";
        }
        if(root.right == null){
            return root.val+"("+tree2str(root.left)+")";
        }
        return root.val+"("+tree2str(root.left)+")("+tree2str(root.right)+")";
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();
        System.out.println(constructStringFromBinaryTree.tree2str(null));
    }
}

