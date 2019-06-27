package com.company.Lists;

import java.util.Stack;

/*
    lc 234
    fast/slow pointers
 */
public class LC234_palindromLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        // find the middle of LL
        ListNode slow = head;
        ListNode fast = head;
        ListNode half_head = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast == null){
            // the linkedList has length with an even numbe
            half_head = reverse(slow);
        }
        else if(fast.next == null){
            // the linkedList has a length with an odd number
            // the slow ptr is the middle of LL
            half_head = reverse(slow.next);
        }


        fast = head;
        while(half_head != null){
            if(fast.val != half_head.val) return false;
            fast = fast.next;
            half_head = half_head.next;
        }
        return true;
    }


    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode curNode = head;
            head = head.next;
            curNode.next = prev;
            prev = curNode;
        }
        return prev;
    }

    public boolean isPalindromeWithStack(ListNode head) {
        /*
            using stack
        */
        if(head == null) return true;

        Stack<ListNode> s = new Stack<>();
        ListNode curNode = head;
        while(curNode != null){
            s.push(curNode);
            curNode = curNode.next;
        }
        while(head != null){
            if(head.val != s.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;

    }
}
