package main.java.com.leetcode._141;

import main.java.com.leetcode.common.models.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
