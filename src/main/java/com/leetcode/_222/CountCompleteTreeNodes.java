package main.java.com.leetcode._222;

import main.java.com.leetcode.common.models.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int nodes = 0;
        int h = height(root);
        while (root != null){
            if(height(root.right) == h - 1){
                nodes += 1 << h;
                root = root.right;
            }else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }


    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        System.out.println(2 << 3);
        System.out.println(5 << 2);
    }

}
