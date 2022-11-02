package leetcode._92;

//https://leetcode.com/problems/reverse-linked-list-ii/solution/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(left > 1){
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        ListNode con = prev;
        ListNode tail = cur;
        ListNode third = null;
        while(right > 0){
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            right--;
        }
        if(con != null){
            con.next = prev;
        }else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
