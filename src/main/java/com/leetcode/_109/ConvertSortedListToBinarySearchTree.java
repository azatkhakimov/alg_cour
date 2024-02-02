package main.java.com.leetcode._109;

import main.java.com.leetcode.common.models.ListNode;
import main.java.com.leetcode.common.models.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return bst(head, null);
    }

    private TreeNode bst(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail){
            return null;
        }
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode h = new TreeNode(slow.val);
        h.left = bst(head, slow);
        h.right = bst(slow.next, tail);
        return h;
    }

    public static void main(String[] args) {

    }
}
