package main.java.com.leetcode._725;

import main.java.com.leetcode.common.models.ListNode;

public class SplitLinkedListinParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }

        int width = n / k;
        int rem = n % k;
        var ans = new ListNode[k];
        cur = head;
        for (int i = 0; i < k; i++) {
            var root = cur;
            for(int j = 0; j < width+(i<rem ? 1 : 0)-1;j++){
                if(cur != null){
                    cur = cur.next;
                }
            }
            if(cur != null){
                var prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = root;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
