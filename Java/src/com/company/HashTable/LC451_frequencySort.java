package com.company.HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC451_frequencySort {
    public String frequencySort(String s) {

        StringBuilder res = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> top = pq.poll();
            for(int i = 0; i < top.getValue(); i++){
                res.append(top.getKey());
            }
        }

        return new String(res);
    }
}
