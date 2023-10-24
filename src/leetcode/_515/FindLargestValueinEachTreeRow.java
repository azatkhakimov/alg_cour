package leetcode._515;

import leetcode.common.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int currLength = queue.size();
            int curMax = Integer.MIN_VALUE;
            for (int i = 0; i < currLength; i++) {
                TreeNode node = queue.remove();
                curMax = Math.max(curMax, node.val);

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(curMax);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
