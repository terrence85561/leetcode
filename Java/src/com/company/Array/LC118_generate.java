package com.company.Array;

import java.util.LinkedList;
import java.util.List;

public class LC118_generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if(numRows == 0) return res;
        int[] prev = new int[]{1};
        for(int i = 1; i <= numRows; i++){
            int[] cur = new int[i];
            for(int j = 0; j < cur.length; j++){
                cur[j] = (j-1 >=0 ? prev[j-1] : 0) + (j > prev.length-1 ? 0 : prev[j]);
            }
            List<Integer> list = new LinkedList<>();
            for(int k = 0; k < cur.length; k++){
                list.add(cur[k]);
            }
            res.add(list);
            prev = cur;
        }
        return res;

    }
}
