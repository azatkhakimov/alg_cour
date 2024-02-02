package main.java.com.leetcode._86;

import main.java.com.leetcode.common.models.ListNode;

public class PartitionList {


    public ListNode partition(ListNode head, int x) {
        ListNode firstDummy = new ListNode(0);
        ListNode secondDummy = new ListNode(0);
        ListNode cur1 = firstDummy;
        ListNode cur2 = secondDummy;
        while (head != null){
            if(head.val < x) {
                cur1.next = head;
                cur1 = head;
            }else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = secondDummy.next;
        return firstDummy.next;
    }

    public static void main(String[] args) {

    }
}
