package leetcode.recursive;

import java.util.Random;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        Random random = new Random();
        random.nextInt(5);
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
