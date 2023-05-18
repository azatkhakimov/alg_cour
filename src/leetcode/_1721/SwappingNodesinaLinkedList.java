package leetcode._1721;

public class SwappingNodesinaLinkedList {



    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode  slow = head;
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        first = fast;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        second = slow;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }

    public static void main(String[] args) {
        var s = new SwappingNodesinaLinkedList();
    }


 class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
