package leetcode._530;

import leetcode.common.models.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MinimumAbsoluteDifferenceinBST {
    List<Integer> treeValues = new ArrayList<>();


    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        Collections.sort(treeValues);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < treeValues.size(); i++) {
            diff = Math.min(diff, treeValues.get(i)-treeValues.get(i-1));
        }
        return diff;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        treeValues.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }


    public static void main(String[] args) {

    }
}
