package com.company.Lists;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;
    private ListNode head;


    public ListNode(int val){
        val = val;
        ListNode next;
    }

    public ListNode getNext(){
        return this.next;
    }

    public void setNext(ListNode node){
        this.next = node;
    }


}
