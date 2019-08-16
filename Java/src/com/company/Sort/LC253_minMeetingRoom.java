package com.company.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253_minMeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        if(intervals.length == 1) return 1;

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int room = 1;
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++ ){
            if(intervals[i][0] < intervals[i-1][1]){
                if(pq.isEmpty()){
                    pq.offer(intervals[i]);
                    continue;
                }
                if(pq.peek()[1] > intervals[i][0]){
                    pq.offer(intervals[i]);
                    room++;
                }else{
                    pq.offer(intervals[i]);
                    pq.poll();
                }
            }else{
                pq.offer(intervals[i]);
                pq.poll();
            }
        }
        return room;


    }
}
