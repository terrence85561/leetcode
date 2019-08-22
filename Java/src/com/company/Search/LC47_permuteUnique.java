package com.company.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, cur, nums.length, 0, used);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int select, int level, boolean[] used){
        if(select == level){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && used[i-1]) continue;
            cur.add(nums[i]);
            used[i] = true;

            dfs(nums, res, cur, select, level+1, used);
            cur.remove(cur.size()-1);
            used[i] = false;
        }
    }
}
