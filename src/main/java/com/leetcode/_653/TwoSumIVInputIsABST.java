package main.java.com.leetcode._653;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if(root == null){
            return false;
        }
        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }

    public static void main(String[] args) {
        TwoSumIVInputIsABST twoSumIVInputIsABST = new TwoSumIVInputIsABST();
        TreeNode treeNode = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
        System.out.println(twoSumIVInputIsABST.findTarget(treeNode, 9));
    }


}
