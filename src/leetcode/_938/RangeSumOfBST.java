package leetcode._938;

import leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=SIdrJwWp3H0
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum =  0;
        if(root == null){
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if(curr.val >= low && curr.val <= high){
                sum += curr.val;
            }
            if(curr.left != null && curr.val > low){
                queue.add(curr.left);
            }
            if(curr.right != null && curr.val < high){
                queue.add(curr.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}

