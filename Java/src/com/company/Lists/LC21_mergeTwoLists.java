package com.company.Lists;

public class LC21_mergeTwoLists {
    public ListNode mergeTwoListsWithIteration(ListNode l1, ListNode l2) {
        /*
            iterative
         */
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummyhead = new ListNode(-1);
        ListNode curNode = dummyhead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curNode.next = l1;
                l1 = l1.next;
            }else{
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if(l1 == null){
            curNode.next = l2;
        }
        if(l2 == null){
            curNode.next = l1;
        }

        return dummyhead.next;

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        /*
            recursive
         */
        // base case
        if(l1 == null || l2 == null){
            if(l1 == null) return l2;
            else return l1;
        }

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
