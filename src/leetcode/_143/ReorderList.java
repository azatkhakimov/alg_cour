package leetcode._143;

import leetcode.common.models.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curNode = node;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = nextNode;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2){
        while(l1 != null){
            ListNode l1next = l1.next;
            ListNode l2next = l2.next;
            l1.next = l2;
            if(l1next == null){
                break;
            }
            l2.next = l1next;
            l1 = l1next;
            l2 = l2next;
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(reorderList.reverse(listNode));
    }
}
}
