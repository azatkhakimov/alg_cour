package leetcode.tree._103;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, result, 0);
        return result;
    }

    private void travel(TreeNode current, List<List<Integer>> result, int level) {
        if (current == null) {
            return;
        }
        if (result.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }

        List<Integer> collection = result.get(level);
        if (level % 2 == 0) {
            collection.add(current.val);
        } else {
            collection.add(0, current.val);
        }
        travel(current.left, result, level + 1);
        travel(current.right, result, level + 1);
    }


}
