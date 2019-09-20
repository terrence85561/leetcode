package com.company.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i <= nums.length; i++){
            List<Integer> cur = new LinkedList<>();
            dfs(nums, res, cur, i, 0, 0);
        }

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int select, int start, int level){
        if(level == select){
            res.add(new LinkedList<>(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(nums, res, cur, select, i+1, level+1);
            cur.remove(cur.size()-1);
        }
    }


}
