package main.java.com.leetcode._94;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);
        return answer;
    }

    private void inorder(TreeNode node, List<Integer> answer) {
        if(node == null){
            return;
        }
        inorder(node.left, answer);
        answer.add(node.val);
        inorder(node.right, answer);
    }

    public static void main(String[] args) {
        var b = new BinaryTreeInorderTraversal();
    }
}
