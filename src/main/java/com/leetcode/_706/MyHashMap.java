package main.java.com.leetcode._706;

public class MyHashMap {

    private class ListNode {
        int key;
        int val;
        ListNode next;

        public ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private static final int size = 19997;
    private static final int mult = 12582917;
    ListNode[] data;

    public MyHashMap() {
        this.data = new ListNode[size];
    }

    public void put(int key, int value) {
        remove(key);
        int hash = hash(key);
        ListNode node = new ListNode(key, value, data[hash]);
        data[hash] = node;
    }

    public int get(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        while (node != null){
            if(node.key == key){
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        if(node == null){
            return;
        }
        if(node.key == key){
            data[hash] = node.next;
        }else{
            while (node.next != null){
                if(node.next.key == key){
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }
    }

    private int hash(int key) {
        return (int) ((long) key * mult % size);
    }


}
