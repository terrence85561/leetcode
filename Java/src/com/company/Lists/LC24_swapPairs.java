package com.company.Lists;
/*
    LC24
    Linkedlist
 */
public class LC24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        // corner case
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode curNode = dummyhead;
        while(curNode.next != null && curNode.next.next != null ){
            ListNode temp = curNode;
            ListNode nextNode = temp.next;

            temp.next = nextNode.next;
            nextNode.next = nextNode.next.next;
            temp.next.next = nextNode;

            curNode = curNode.next.next;
        }
        return dummyhead.next;
    }
    public ListNode swapPairsRec(ListNode head){
                /*
            recursively
        */
        // corner case
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairsRec(head.next.next);
        temp.next = head;
        return temp;
    }
}
