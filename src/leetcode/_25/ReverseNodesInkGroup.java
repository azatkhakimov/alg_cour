package leetcode._25;

import leetcode.common.models.ListNode;

public class ReverseNodesInkGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr != null) {
            ListNode tracker = ptr;
            for (int i = 0; i < k; i++) {
                if (tracker == null) {
                    break;
                }
                tracker = tracker.next;
            }

            if (tracker == null) {
                break;
            }

            ListNode[] updatedNodes = reverse(ptr.next, k);
            ListNode prev = updatedNodes[0];
            ListNode curr = updatedNodes[1];
            ListNode lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = curr;
            ptr.next = prev;
            ptr = lastNodeOfReversedGroup;
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode node, int k) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{prev, curr};
    }

    public static void main(String[] args) {
        var r = new ReverseNodesInkGroup();
    }
}
