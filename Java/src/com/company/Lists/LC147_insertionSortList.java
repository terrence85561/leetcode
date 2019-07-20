package com.company.Lists;

public class LC147_insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;

        ListNode guard = new ListNode(-1);
        guard.next = head;

        ListNode cur = guard.next;

        while(cur != null && cur.next != null){
            if(cur.next.val >= cur.val){
                cur = cur.next;
            }else{
                ListNode nextNode = cur.next.next;
                ListNode temp = cur.next;
                cur.next = nextNode;

                ListNode prev = guard;
                ListNode ptr = guard.next;

                while(ptr != cur.next){
                    if(ptr.val >= temp.val){
                        prev.next = temp;
                        temp.next = ptr;
                        break;
                    }
                    ptr = ptr.next;
                    prev = prev.next;

                }
            }

        }

        return guard.next;
    }
}
