package main.java.com.leetcode._876;

import main.java.com.leetcode.common.models.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList list = new MiddleOfTheLinkedList();
    }
}

