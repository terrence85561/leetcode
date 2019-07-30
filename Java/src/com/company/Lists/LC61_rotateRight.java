package com.company.Lists;

public class LC61_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int size = 1;
        ListNode tail;

        // compute the size of list
        for(tail = head; tail.next != null; tail=tail.next){
            size++;
        }

        if(k > size) k = k % size;
        if(size == k) return head;



        ListNode newTail = head;
        int counter = 0;

        for(int i = 0; i < size-1; i++){
            if(counter == k){
                newTail = newTail.next;
            }else{
                counter++;
            }
        }

        if(newTail.next == null) return head;

        ListNode newHead = newTail.next;
        newTail.next = null;

        tail.next = head;
        return newHead;

    }

}
