package leetcode._148;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

//https://www.youtube.com/watch?v=pNTc1bM1z-4
public class SortList {
    public ListNode sortList(ListNode head) {
        HashMap<String, Integer> map;
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);
        return merge(leftSide, rightSide);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode sortedNode = new ListNode(0);
        ListNode currNode = sortedNode;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                currNode.next =  l1;
                l1 = l1.next;
            }else{
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;

        }
        if(l1 != null){
            currNode.next = l1;
            l1 = l1.next;
        }
        if(l2 != null){
            currNode.next = l2;
            l2 = l2.next;
        }

        return sortedNode.next;
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode testNode = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println("Before "+testNode);
        System.out.println("After "+sortList.sortList(testNode));

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
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
