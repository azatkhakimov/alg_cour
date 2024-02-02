package main.java.com.leetcode._958;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }

        boolean nullNodeFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                nullNodeFound = true;
            }else{
                if(nullNodeFound){
                    return false;
                }
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

