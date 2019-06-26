package com.company.Lists;

import java.util.List;

/*
    lc 2
    linked list
 */
public class LC2_addTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(-1);
        ListNode curNode = dummyhead;
        int carry = 0;
        while(l1!=null || l2!=null){
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            int res = sum  % 10;
            carry = sum / 10;
            curNode.next = new ListNode(res);
            curNode = curNode.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry != 0){
            curNode.next = new ListNode(carry);
        }

        return dummyhead.next;

    }

    private static void print_out(ListNode head){
        ListNode cur = head.next;
        while(cur!=null){
            System.out.print(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LC2_addTwoNumber A = new LC2_addTwoNumber();
        ListNode ahead = new ListNode(-1);
        int[] a = {2,4};
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
