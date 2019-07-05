package com.company.Lists;

public class LC86_partition {

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ListNode bigHead = new ListNode(-1);
        ListNode smallHead = new ListNode(-1);
        ListNode dummy = new ListNode(-1);

        ListNode big = bigHead;
        ListNode small = smallHead;
        dummy.next = head;
        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else if(head.val >= x){
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }

        big.next = null;
        small.next = bigHead.next;

        return smallHead.next;
    }
}
