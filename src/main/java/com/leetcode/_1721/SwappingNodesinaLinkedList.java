package main.java.com.leetcode._1721;

import main.java.com.leetcode.common.models.ListNode;

public class SwappingNodesinaLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode front = null;
        ListNode end = null;
        ListNode curr = head;
        int count = 0;
        while (curr != null){
            count++;
            if(end != null){
                end = end.next;
            }
            if(count == k){
                front = curr;
                end = head;
            }
            curr = curr.next;
        }
        int tmp = front.val;
        front.val = end.val;
        end.val = tmp;
        return head;
    }

    public static void main(String[] args) {
        var s = new SwappingNodesinaLinkedList();
    }

}
