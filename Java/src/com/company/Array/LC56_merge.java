package com.company.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56_merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        int lo = intervals[0][0];
        int hi = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= hi && intervals[i][1] <= hi ) continue;
            if(intervals[i][0] > hi){
                List<Integer> cur = Arrays.asList(lo, hi);
                res.add(cur);
                lo = intervals[i][0];
            }
            hi = intervals[i][1];
        }
        List<Integer> cur = Arrays.asList(lo, hi);
        res.add(cur);
        int[][] ret = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < 2; j++){
                ret[i][j] = res.get(i).get(j);
            }
        }
        return ret;
    }
}
