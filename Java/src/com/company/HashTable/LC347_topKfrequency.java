package com.company.HashTable;

import java.util.*;

public class LC347_topKfrequency {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length < k) return new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> (x.getValue() - y.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < k; i++){
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
