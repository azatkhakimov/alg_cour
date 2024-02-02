package main.java.com.leetcode._24;

import main.java.com.leetcode.common.models.ListNode;

public class SwapNodePairs {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp;
        while(cur.next != null && cur.next.next != null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next  = first;
            cur = cur.next.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {

    }


}
