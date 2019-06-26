package com.company.Lists;

import java.util.List;
import java.util.Stack;

/*
    lc 445
    linked list
 */
public class LC445_addTwoNumberII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = null;
        Stack<ListNode> l1Stack = new Stack<>();
        Stack<ListNode> l2Stack = new Stack<>();
        while(l1!=null){
            l1Stack.push(l1);
            l1 = l1.next;
        }
        while (l2!=null){
            l2Stack.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        int res;
        while(!(l1Stack.isEmpty()) || !(l2Stack.isEmpty())){
            int sum = (l1Stack.isEmpty() ? 0 : l1Stack.pop().val) + (l2Stack.isEmpty() ? 0 : l2Stack.pop().val) + carry;
            res = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(res);
            newNode.next = dummyhead;
            dummyhead = newNode;
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = dummyhead;
            dummyhead = newNode;
        }

        return dummyhead;
    }

    public static void main(String[] args) {
        LC445_addTwoNumberII A = new LC445_addTwoNumberII();
        ListNode ahead = new ListNode(-1);
        int[] a = {7,2,4,3};
        int[] b = {5,6,4};
        ListNode curNode = ahead;
        for(int i : a){
            curNode.next = new ListNode(i);
            curNode = curNode.next;
        }

        ListNode bhead = new ListNode(-1);
        curNode = bhead;
        for(int i : b){
            curNode.next = new ListNode(i);
            curNode = curNode.next;
        }

        ListNode res = A.addTwoNumbers(ahead.next, bhead.next);

        System.out.println(res.next.next.val);

    }
}
