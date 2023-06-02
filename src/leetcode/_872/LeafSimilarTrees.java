package leetcode._872;

import leetcode.common.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://www.youtube.com/watch?v=uL8YJsJ_3cY
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(leaves1, root1);
        dfs(leaves2, root2);
        return leaves1.equals(leaves2);
    }

    private void dfs(List<Integer> leaves, TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leaves.add(root.val);
        }
        dfs(leaves, root.left);
        dfs(leaves, root.right);
    }


    public static void main(String[] args) {

    }
}

