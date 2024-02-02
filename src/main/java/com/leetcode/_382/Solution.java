package main.java.com.leetcode._382;

import main.java.com.leetcode.common.models.ListNode;

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
