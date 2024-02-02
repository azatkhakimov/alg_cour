package main.java.com.leetcode.common.models;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
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

    public static class ListNodeBuilder {
        public static ListNode arrayToListNode(int[] arr) {
            ListNode result = new ListNode();

            for (int i = arr.length - 1; i >= 0; i--) {
                result = insert(result, arr[i]);
            }

            return result;

        }

        private static ListNode insert(ListNode root, int i) {
            ListNode temp = new ListNode();
            temp.val = i;
            temp.next = root;
            root = temp;
            return root;
        }
    }
}
