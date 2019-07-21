package com.company.Design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC460_LFUCache {
    /*
        time O(logn)
     */
    private class Node{
        private int key;
        private int value;
        private int freq;
        private int tick;
        public Node(int key, int value, int tick){
            this.key = key;
            this.value = value;
            this.freq = 1;
            this.tick = tick;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private int max_tick;

    private PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.freq < o2.freq){
                return -1;
            }
            else if (o1.freq > o2.freq){
                return 1;
            }else{
                if(o1.tick < o2.tick){
                    return -1;
                }
                else if(o1.tick > o2.tick){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
    });
    public LC460_LFUCache(int capacity) {
        this.capacity = capacity;
        this.max_tick = 1;
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        pq.remove(node);
        int ret = node.value;
        node.freq++;
        node.tick = ++this.max_tick;
        pq.offer(node);
        if(map.size() > this.capacity){
            Node min = pq.poll();
            map.remove(min.key);
        }
        return ret;
    }

    public void put(int key, int value) {
        if(this.capacity == 0) return;

        if(get(key) != -1){
            map.get(key).value = value;
        }else{
            Node newNode = new Node(key, value, ++this.max_tick);
            map.put(key, newNode);
            if(map.size() > this.capacity){
                Node min1 = pq.poll();
                map.remove(min1.key);
            }
            pq.offer(newNode);
        }
    }
}
