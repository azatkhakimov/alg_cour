package main.java.com.leetcode._863;

import main.java.com.leetcode.common.models.TreeNode;

import java.util.*;

public class AllNodesDistanceKinBinaryTree {


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfsBuild(root, null, graph);
        List<Integer> answer = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{target.val, 0});
        visited.add(target.val);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int distance = cur[1];
            if (distance == k) {
                answer.add(node);
                continue;
            }
            for (Integer neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.add(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        return answer;
    }

    private void dfsBuild(TreeNode cur, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (cur != null && parent != null) {
            int curVal = cur.val;
            int parentVal = parent.val;
            graph.putIfAbsent(curVal, new ArrayList<>());
            graph.putIfAbsent(parentVal, new ArrayList<>());
            graph.get(curVal).add(parentVal);
            graph.get(parentVal).add(curVal);
        }

        if (cur != null && cur.left != null) {
            dfsBuild(cur.left, cur, graph);
        }

        if (cur != null && cur.right != null) {
            dfsBuild(cur.right, cur, graph);
        }
    }


    public static void main(String[] args) {
        var a = new AllNodesDistanceKinBinaryTree();
    }
}
