package leetcode._2074;

import leetcode.common.models.ListNode;

import java.util.List;

public class ReverseNodesInEvenLengthGroups {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        ListNode node = null;
        ListNode reverse = null;
        ListNode currNext = null;
        ListNode curr = null;
        ListNode prevNext = null;
        int groupLen = 2;
        int numNodes = 0;
        while (prev.next != null){
            node = prev;
            numNodes = 0;
            for (int i = 0; i < groupLen; i++) {
                if(node.next == null){
                    break;
                }
                numNodes += 1;
                node = node.next;
            }
            if(numNodes % 2 != 0){
                prev = node;
            }else {
                reverse = node.next;
                curr = prev.next;
                for (int j = 0; j < numNodes; j++) {
                    currNext = curr.next;
                    curr.next = reverse;
                    reverse = curr;
                    curr = currNext;
                }
                prevNext = prev.next;
                prev.next = node;
                prev = prevNext;
            }
            groupLen += 1;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
