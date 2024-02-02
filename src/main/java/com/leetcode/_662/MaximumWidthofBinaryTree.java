package main.java.com.leetcode._662;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int max = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int first = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int level  = pair.level;
                if(i == 0){
                    first =  level;
                }
                if(i == size-1){
                    end = level;
                }
                if(node.left != null){
                    queue.add(new Pair(node.left, level*2));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, level*2+1));
                }
            }
            max = Math.max(max, end-first+1);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumWidthofBinaryTree m = new MaximumWidthofBinaryTree();
    }

}
