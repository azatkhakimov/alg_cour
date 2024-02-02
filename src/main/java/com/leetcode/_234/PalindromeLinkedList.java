package main.java.com.leetcode._234;

import main.java.com.leetcode.common.models.ListNode;


public class PalindromeLinkedList {

    public ListNode initOne(){
        return new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
    }

    public ListNode initTwo(){
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverted = revert(slow);
        if(compareTwoHalves(head, reverted)){
            return true;
        }
        return false;
    }

    private boolean compareTwoHalves(ListNode node1, ListNode node2) {
        while (node1 != null && node2 != null){
            if(node1.val != node2.val){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    private ListNode revert(ListNode node) {
        ListNode reverted = null;
        while (node != null){
            ListNode next = node.next;
            node.next = reverted;
            reverted = node;
            node = next;
        }
        return reverted;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(palindromeLinkedList.initOne()));
        System.out.println(palindromeLinkedList.isPalindrome(palindromeLinkedList.initTwo()));
    }
}
