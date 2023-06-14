package leetcode._382;

import leetcode.common.models.ListNode;

import java.util.List;
import java.util.Map;

class Solution {
    private ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int scope = 1;
        int chosenValue = 0;
        ListNode curr = this.head;
        while (curr != null){
            if(Math.random() < 1.0 / scope){
                chosenValue = curr.val;
            }
            scope += 1;
            curr = curr.next;
        }
        return chosenValue;
    }
}
