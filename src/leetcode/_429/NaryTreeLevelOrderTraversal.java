package leetcode._429;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                curLevel.add(curNode.val);
                for (Node child : curNode.children) {
                    queue.offer(child);
                }
            }
            result.add(curLevel);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
