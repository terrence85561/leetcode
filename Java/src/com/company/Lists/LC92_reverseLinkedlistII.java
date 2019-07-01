package com.company.Lists;

public class LC92_reverseLinkedlistII {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        // find the node before n-th position
        for(int i = 1; i < m ; i++){
            prev = prev.next;
        }

        // record the last node after reversing
        ListNode end = prev.next;

        // reverse from n to m
        ListNode cur = prev.next;
        ListNode j = null;

        for(int i = m; i <= n; i++){
            ListNode temp = cur;
            cur = cur.next;
            temp.next = j;
            j = temp;
        }

        // connect the reversed part with the rest
        prev.next = j;
        end.next = cur;

        return dummy.next;
    }
}
