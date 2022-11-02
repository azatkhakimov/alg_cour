package leetcode._61;

//https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ||head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        int count;
        for(count = 0; fast.next != null; count++){
            fast = fast.next;
        }

        for(int j = count-k%count; j > 0; j--){
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }


    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        System.out.println(rotateList.rotateRight(listNode, 2));//Output: [4,5,1,2,3]
    }
}

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

       @Override
       public String toString() {
           return "ListNode{" +
                   "val=" + val +
                   ", next=" + next +
                   '}';
       }
   }
