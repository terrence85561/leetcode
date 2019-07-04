package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class LC78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            findSubset(nums, res, i);
        }
        return res;
    }

    private void findSubset(int[] nums, List<List<Integer>> res, int select){

        List<Integer> cur = new ArrayList<>();
        dfs(nums, select ,res, cur, 0, 0);
    }

    private void dfs(int[] nums, int select, List<List<Integer>> res, List<Integer>cur, int level, int start){
        // base case
        if(level == select){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(nums, select, res, cur, level+1, i+1);
            cur.remove(cur.size()-1);
        }
    }


}
