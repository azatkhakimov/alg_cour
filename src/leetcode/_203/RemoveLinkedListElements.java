package leetcode._203;

import leetcode.common.models.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        var r = new RemoveLinkedListElements();
        ListNode listNode = ListNode.ListNodeBuilder.arrayToListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(r.removeElements(listNode, 6));//Output: [1,2,3,4,5]

    }
}
