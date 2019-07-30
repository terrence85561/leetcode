package com.company.Lists;

public class LC148_sortList {
    public ListNode sortList(ListNode head) {
        /*
            top down mergesort solution
            O(nlogn) time
            O(logn) space
        */

        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(mid));

    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode guard = new ListNode(-1);
        ListNode tail = guard;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }

        if(l1 == null){
            tail.next = l2;
        }
        if(l2 == null){
            tail.next = l1;
        }
        return guard.next;

    }
//    public ListNode sortList(ListNode head) {
//        /*
//            bottom up mergesort
//            O(nlogn)
//            O(1)space
//         */
//    }
}
