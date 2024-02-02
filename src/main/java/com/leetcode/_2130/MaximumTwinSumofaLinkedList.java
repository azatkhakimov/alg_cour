package main.java.com.leetcode._2130;

import main.java.com.leetcode.common.models.ListNode;

public class MaximumTwinSumofaLinkedList {

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextNode;
        ListNode prev = null;
        while(slow != null){
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int maxSum = 0;
        while (prev != null){
            maxSum = Math.max(maxSum, start.val + prev.val);
            prev = prev.next;
            start = start.next;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        var m = new MaximumTwinSumofaLinkedList();
    }
}
