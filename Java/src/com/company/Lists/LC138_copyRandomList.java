package com.company.Lists;

import java.util.HashMap;

/*
    linkedlist
    hashmap

 */
public class LC138_copyRandomList {

    public Node copyRandomList(Node head) {
        /*
            time O(n)
            space O(n)
         */
        if(head == null) return head;

        HashMap<Node, Node> lookup = new HashMap<>();

        Node curNode = head;
        Node dummy = new Node(-1, null, null);
        Node copyNode = dummy;

        while(curNode != null){
            Node copy = new Node(curNode.val, null, null);
            lookup.put(curNode, copy);
            copyNode.next = copy;
            copyNode = copy;
            curNode = curNode.next;
        }

        curNode = head;
        copyNode = dummy.next;

        while(curNode != null){
            if(!(lookup.containsKey(curNode.random)) && curNode.random != null){
                Node random = new Node(curNode.random.val, null, null);
                lookup.put(curNode.random, random);
            }

            copyNode.random = lookup.get(curNode.random);
            curNode = curNode.next;
            copyNode = copyNode.next;
        }

        return dummy.next;


    }
}
