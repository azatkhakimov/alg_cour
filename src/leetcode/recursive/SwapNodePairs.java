package leetcode.recursive;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)

 */
public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;

    }

    public static void main(String[] args) {
        SwapNodePairs swapNodePairs = new SwapNodePairs();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode listNode = swapNodePairs.swapPairs(head);
        System.out.println(listNode);
    }
}
