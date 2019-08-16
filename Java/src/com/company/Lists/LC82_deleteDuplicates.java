package com.company.Lists;

public class LC82_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode guard = new ListNode(-1);
        ListNode cur = head;
        ListNode prev = guard;
        ListNode node = guard;
        while(cur != null){
            if((cur.next != null && ((cur.next.val != cur.val && prev.val != cur.val) || (prev == guard && cur.next.val != cur.val))) || (cur.next == null && prev.val != cur.val)){
                node.next = cur;
                node = node.next;
            }

            prev = cur;
            cur = cur.next;
            prev.next = null;
        }
        return guard.next;
    }
}
