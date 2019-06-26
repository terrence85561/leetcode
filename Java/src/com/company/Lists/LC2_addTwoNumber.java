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
        ListNode l1_curNode = l1;
        ListNode l2_curNode = l2;
        while(l1_curNode!=null || l2_curNode!=null){
            int l1_val, l2_val, res;
            if(l1_curNode==null){
                l1_val = 0;
                l2_val = l2_curNode.val;
                l2_curNode = l2_curNode.next;
            }
            else if(l2_curNode==null){
                l1_val = l1_curNode.val;
                l2_val = 0;
                l1_curNode = l1_curNode.next;
            }else{
                l1_val = l1_curNode.val;
                l2_val = l2_curNode.val;
                l1_curNode = l1_curNode.next;
                l2_curNode = l2_curNode.next;
            }
            res = (carry + l1_val + l2_val) % 10;
            carry = (l1_val + l2_val + carry) / 10;

            curNode.next = new ListNode(res);
            curNode = curNode.next;
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
