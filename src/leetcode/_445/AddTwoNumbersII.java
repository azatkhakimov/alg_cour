package leetcode._445;

import leetcode.common.models.ListNode;

import java.util.List;
import java.util.Stack;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int totalSum = 0;
        int carry = 0;
        ListNode ans = new ListNode();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty()){
                totalSum += s1.pop();
            }
            if(!s2.isEmpty()){
                totalSum += s2.pop();
            }
            ans.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
        }
        return carry == 0 ? ans.next : ans;
    }

    public static void main(String[] args) {
        var a = new AddTwoNumbersII();
//        System.out.println(a.addTwoNumbers());
    }
}
