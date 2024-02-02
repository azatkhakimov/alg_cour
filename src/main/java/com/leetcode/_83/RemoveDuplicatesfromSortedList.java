package main.java.com.leetcode._83;

import main.java.com.leetcode.common.models.ListNode;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        var r = new RemoveDuplicatesfromSortedList();
        System.out.println(
                r.deleteDuplicates(ListNode.ListNodeBuilder.arrayToListNode(new int[]{1,1,2}))
        );
    }
}
