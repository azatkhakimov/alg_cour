package leetcode.recursive;

import java.util.concurrent.atomic.AtomicLong;

/*206. Reverse Linked List
* Given the head of a singly linked list, reverse the list, and return the reversed list.
* Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
* */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode prev) {
        if(head == null){
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
        return reverse(head, prev);
    }
}
