package com.company.Lists;

import java.util.Stack;

/*
    lc 234
    fast/slow pointers
 */
public class LC234_palindromLinkedList {

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
