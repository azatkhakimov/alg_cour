package leetcode._144;

import leetcode.common.models.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        helper(node.left, res);
        helper(node.right, res);
    }

    public static void main(String[] args) {

    }
}
