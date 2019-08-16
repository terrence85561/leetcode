package com.company.Lists;

public class LC83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode prev = head;
        ListNode next = prev.next;

        while(next != null){
            if(next.val == prev.val){
                prev.next = next.next;
                next = next.next;
            }else{
                next = next.next;
                prev = prev.next;
            }
        }

        return head;
    }
}
