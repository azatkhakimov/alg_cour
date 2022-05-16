package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    int leftSum;
    int rightSum;
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = 0;
        while(!queue.isEmpty()){
            maxSum = 0;
            for(int i = 0; i<queue.size(); i++){
                TreeNode current = queue.poll();
                maxSum += current.val;
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }

        }
        return maxSum;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(root));
    }
}
