package main.java.com.leetcode.tree._230;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.LinkedList;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0){
                return root.val;
            }
            root = root.right;
        }
    }
}
