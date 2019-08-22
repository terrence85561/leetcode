package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class LC46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        dfs(nums, cur, used, res, nums.length, 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> cur, boolean[] used, List<List<Integer>> res, int select, int level){
        if(level == select){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] == true) continue;
            cur.add(nums[i]);
            used[i] = true;
            dfs(nums, cur, used, res, select, level+1);
            cur.remove(cur.size()-1);
            used[i] = false;
        }
    }
}
