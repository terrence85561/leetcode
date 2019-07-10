package com.company.Design;

import java.util.HashMap;

public class LC146_LRUCache {

    // (1,1) -> (2,2)
    // push_back: the most recent node in the tail
    // del_head: the least recent node delete

    private class Node {
        private int value;
        private int key;
        private Node next;
        private Node prev;

        public Node(int key, int value){
            this.value = value;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);

    public LC146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        int val = node.value;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        push_back(node);

        return val;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            push_back(node);
            return;
        }

        Node node = new Node(key, value);
        push_back(node);
        map.put(key, node);
        if(capacity < map.size()){
            del_head();
        }


    }

    private void push_back(Node node){
        Node lastNode = this.tail.prev;
        lastNode.next = node;
        node.next = this.tail;

        node.prev = lastNode;
        this.tail.prev = node;

    }

    private void del_head(){
        Node least = this.head.next;
        this.head.next = least.next;
        least.next.prev = this.head;
        map.remove(least.key);
    }


}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */