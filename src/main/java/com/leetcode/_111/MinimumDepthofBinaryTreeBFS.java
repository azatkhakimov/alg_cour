package main.java.com.leetcode._111;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTreeBFS {

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null){
                    return depth;
                }
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        var m = new MinimumDepthofBinaryTreeBFS();
    }
}
