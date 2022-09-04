package leetcode._987;

import java.util.*;

public class VerticalOrderTraversalOfaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0 , map);
        List<List<Integer>> list = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> value : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : value.values()) {
                while (!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    private void dfs(TreeNode root, int x, int y, Map<Integer, Map<Integer, PriorityQueue<Integer>>> map) {
        if(root == null){
            return;
        }
        if(!map.containsKey(x)){
            map.put(x, new TreeMap<>());
        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x-1, y+1,map);
        dfs(root.right, x+1, y+1, map);
    }

    public static void main(String[] args) {
        VerticalOrderTraversalOfaBinaryTree test = new VerticalOrderTraversalOfaBinaryTree();
        System.out.println(test.verticalTraversal(null));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
