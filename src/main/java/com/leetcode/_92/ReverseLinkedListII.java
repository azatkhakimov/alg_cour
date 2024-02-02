package main.java.com.leetcode._92;

import main.java.com.leetcode.common.models.ListNode;


public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode lpn = null;
        ListNode right_n = null;
        ListNode reverseHead = null;
        int count = 1;
        while (count < left && curr != null){
            lpn = curr;
            curr = curr.next;
            count++;
        }
        if(curr != null){
            ListNode rpn = curr;
            while (count <= right && rpn != null){
                right_n = rpn;
                rpn = right_n.next;
                count++;
            }
            if(right_n != null){
                reverseHead = reverse(curr, left, right);
            }
            if(lpn != null){
                lpn.next = reverseHead;
            }
            if(rpn !=null){
                ListNode tmp = reverseHead;
                while (tmp.next != null){
                    tmp = tmp.next;
                }
                tmp.next = rpn;
            }
        }
        if(lpn != null){
            return head;
        }else {
            return reverseHead;
        }
    }

    private ListNode reverse(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        while (right >= left){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}

