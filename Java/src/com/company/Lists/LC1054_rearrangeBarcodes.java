package com.company.Lists;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1054_rearrangeBarcodes {
    private class BC{
        int cnt;
        int val;
        public BC(int cnt, int val){
            this.cnt = cnt;
            this.val = val;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int size = barcodes.length;
        int[] res = new int[size];

        HashMap<Integer, Integer> counter = new HashMap<>();

        PriorityQueue<BC> pq = new PriorityQueue<>(new Comparator<BC>() {
            @Override
            public int compare(BC o1, BC o2) {
                return o2.cnt - o1.cnt;
            }
        });

        for(int i = 0; i < size; i++){
            Integer prev_cnt = counter.putIfAbsent(barcodes[i], 1);
            if(prev_cnt != null){
                counter.put(barcodes[i], prev_cnt + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : counter.entrySet()){
            pq.offer(new BC(entry.getValue(), entry.getKey()));
        }

        int idx = 0;
        while(!pq.isEmpty()){
            BC peek = pq.poll();
            if(idx > 0 && peek.val == res[idx-1]){
                BC peek2 = pq.poll();
                res[idx++] = peek2.val;
                peek2.cnt--;
                if(peek2.cnt > 0) pq.offer(peek2);
                pq.offer(peek);

            }else{
                res[idx++] = peek.val;

                peek.cnt--;
                if (peek.cnt > 0) {
                    pq.offer(peek);
                }
            }
        }
        return res;
    }

}
