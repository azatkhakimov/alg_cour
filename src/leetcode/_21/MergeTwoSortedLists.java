package leetcode._21;

import leetcode.common.models.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(0);
        ListNode curr = merged;
        while(list1 != null && list2 !=null){
            if(list1.val > list2.val){
                curr.next = list2;
                list2 = list2.next;
            }else{
                curr.next = list1;
                list1 =  list1.next;
            }
            curr = curr.next;
        }

        if(list1 != null){
            curr.next = list1;
        }
        if(list2 != null){
            curr.next = list2;
        }
        return merged.next;
    }
    public static void main(String[] args) {

    }
}
