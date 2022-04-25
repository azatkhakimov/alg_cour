package leetcode.linkedlist;

import java.util.List;

public class PalindromeLinkedList {
    private class ListNode {
        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        int val;
        ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode initOne(){
        return new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
    }

    public ListNode initTwo(){
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
    }
    public boolean isPalindrome(ListNode head){
        System.out.println("Before head: "+head);
        if(head == null){
            return true;
        }
        //Find the end of first half and reverse second half
        ListNode firstHalfEnd = endOfFirstHalf(head);
        System.out.println("firstHalfEnd: "+firstHalfEnd);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        System.out.println("secondHalfStart: "+secondHalfStart);
        boolean result = true;
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while (result && p2 != null){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;

        }
        //Restore the list and return result;
        firstHalfEnd.next = reverseList(secondHalfStart);
        System.out.println("firstHalfEnd.next:" +firstHalfEnd);
        return result;

    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(palindromeLinkedList.initOne()));
        System.out.println(palindromeLinkedList.isPalindrome(palindromeLinkedList.initTwo()));
    }
}
