package com.company.Sort;

import java.util.PriorityQueue;

public class LC973_Kclosest {
    /*
        pq
     */
    public int[][] kClosest(int[][] points, int K) {
        int[] origin = new int[]{0, 0};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (int)((Math.pow(a[0]-origin[0], 2) + Math.pow(a[1]-origin[1], 2)) - (Math.pow(b[0]-origin[0], 2) + Math.pow(b[1]-origin[1], 2))));
        for(int i = 0; i < points.length; i++){
            pq.offer(points[i]);
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++){
            res[i] = pq.poll();
        }
        return res;
    }

}
