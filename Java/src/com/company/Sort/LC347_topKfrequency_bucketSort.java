package com.company.Sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC347_topKfrequency_bucketSort {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
            bucket sort
        */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List[] bucket = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new LinkedList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> res = new LinkedList<>();
        for(int i = bucket.length-1; i > 0 && res.size() < k; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
