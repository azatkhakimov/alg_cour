package main.java.com.leetcode._623;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 1;
        while (d < depth-1){
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode node =  queue.remove();
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }
            queue = temp;
            d++;
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;

            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
    }

}
