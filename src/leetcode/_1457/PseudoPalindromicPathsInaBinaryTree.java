package leetcode._1457;

import leetcode.common.models.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/
public class PseudoPalindromicPathsInaBinaryTree {
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        preorder(root, 0);
        return count;
    }

    public void preorder(TreeNode node, int path) {
        if (node != null) {
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path);
        }
    }


    public static void main(String[] args) {
        PseudoPalindromicPathsInaBinaryTree pseudoPalindromicPathsInaBinaryTree = new PseudoPalindromicPathsInaBinaryTree();
    }
}

