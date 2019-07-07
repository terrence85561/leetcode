package com.company.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            findCombination(nums, res, i);
        }
        return res;
    }

    private List<List<Integer>> findCombination(int[] nums, List<List<Integer>> res, int select){

        List<Integer> cur = new ArrayList<>();

        dfs(nums, cur, res, select, 0, 0);

        return res;
    }

    private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> res, int select, int level, int start){

        if(select == level){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            dfs(nums, cur, res, select, level+1, i+1);
            cur.remove(cur.size()-1);
        }
    }

}
