package main.java.com.leetcode._104;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTreeBFS {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {

    }
}
