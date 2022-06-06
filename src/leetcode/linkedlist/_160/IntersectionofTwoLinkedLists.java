package leetcode.linkedlist._160;

import leetcode.recursive.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


