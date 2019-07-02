package com.company.Lists;

import java.util.Stack;

public class LC160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;
        int a_size = 0, b_size = 0;
        ListNode aLast = headA, bLast = headB;
        while(aLast.next != null){
            a_size += 1;
            aLast = aLast.next;
        }
        while(bLast.next != null){
            b_size += 1;
            bLast = bLast.next;
        }

        if(bLast != aLast) return null;

        ListNode curA = headA;
        ListNode curB = headB;
        if(a_size > b_size){
            for(int i = 0; i < a_size - b_size; i++){
                curA = curA.next;
            }
        }else if(b_size > a_size){
            for(int i = 0; i < b_size - a_size; i++){
                curB = curB.next;
            }
        }

        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;






    }
}
