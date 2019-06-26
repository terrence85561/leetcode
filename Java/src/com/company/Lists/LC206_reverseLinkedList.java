package com.company.Lists;
/*
    lc206
    reverse linked list
 */
public class LC206_reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode curNode = head;
            head = head.next;
            curNode.next = prev;
            prev = curNode;
        }
        return prev;



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
