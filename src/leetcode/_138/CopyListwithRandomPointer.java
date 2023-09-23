package leetcode._138;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        var c = new CopyListwithRandomPointer();
        System.out.println(c.copyRandomList(null));
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
