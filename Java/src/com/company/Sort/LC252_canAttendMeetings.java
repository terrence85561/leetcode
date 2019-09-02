package com.company.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class LC252_canAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}