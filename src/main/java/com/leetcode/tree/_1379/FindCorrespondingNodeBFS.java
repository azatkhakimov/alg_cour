package main.java.com.leetcode.tree._1379;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindCorrespondingNodeBFS {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> queueOriginal = new ArrayDeque<>();
        queueOriginal.offer(original);

        Deque<TreeNode> queueCloned = new ArrayDeque<>();
        queueCloned.offer(cloned);

        while (!queueOriginal.isEmpty()){
            TreeNode nodeOriginal  = queueOriginal.poll();
            TreeNode nodeCloned = queueCloned.poll();

            if(nodeOriginal == target){
                return nodeCloned;
            }

            if (nodeOriginal.left != null){
                queueOriginal.offer(nodeOriginal.left);
                queueCloned.offer(nodeCloned.left);
            }
            if(nodeOriginal.right != null){
                queueOriginal.offer(nodeOriginal.right);
                queueCloned.offer(nodeCloned.left);
            }
        }
        return null;
    }

}
