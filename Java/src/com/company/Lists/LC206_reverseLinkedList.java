package com.company.Lists;

import java.util.List;

/*
    lc206
    reverse linked list
 */
public class LC206_reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        /*
            iteration method
         */
        ListNode prev = null;
        while(head != null){
            ListNode curNode = head;
            head = head.next;
            curNode.next = prev;
            prev = curNode;
        }
        return prev;



    }

    public ListNode reverseListRecur(ListNode head) {
        /*
            recursive method
            nice video : https://www.youtube.com/watch?v=O0By4Zq0OFc
         */

        // base case
        if (head == null || head.next == null) return head;

        ListNode reversedListHead = reverseList(head.next);
        ListNode curNode = head.next;
        curNode.next = head;
        head.next = null;

        return reversedListHead;
    }

    public static void main(String[] args) {
        LC206_reverseLinkedList A = new LC206_reverseLinkedList();
        int[] a = {1,2,3,4,5};
        ListNode ahead = new ListNode(-1);
        ListNode curNode = ahead;
        for(int i : a){
            curNode.next = new ListNode(i);
            curNode = curNode.next;
        }

        ListNode res = A.reverseList(ahead.next);
        System.out.println(res.val);




    }
}
