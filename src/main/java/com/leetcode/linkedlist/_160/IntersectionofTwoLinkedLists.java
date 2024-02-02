package main.java.com.leetcode.linkedlist._160;

import main.java.com.leetcode.common.models.ListNode;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB){
            if (pointerA == null){
                pointerA = headB;
            }else {
                pointerA = pointerA.next;
            }

            if(pointerB == null){
                pointerB = headA;
            }else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }

    public static void main(String[] args) {

    }
}


