package leetcode._133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> map) {
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node copy = new Node(node.val);
        map.put(copy.val, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor, map));
        }
        return copy;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();

    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
