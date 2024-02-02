package main.java.com.leetcode._501;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.*;

public class ModeinBinarySearchTree {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int maxFreq = 0;
        for (Integer key : counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }

        List<Integer> ans = new ArrayList<>();
        for (Integer key : counter.keySet()) {
            if (counter.get(key) == maxFreq) {
                ans.add(key);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;

    }

    public static void main(String[] args) {
        var m = new ModeinBinarySearchTree();
        System.out.println(m.findMode(null));
    }

}
