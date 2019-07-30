package com.company.Search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC491_findSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int size = nums.length;
        dfs(nums, res, cur, 0);
        return new ArrayList<>(res);

    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int start){
        if(cur.size() >= 2){
            res.add(new ArrayList<>(cur));
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            if(visited.contains(nums[i])) continue;
            else{
                if(cur.size()==0 || cur.get(cur.size()-1) <= nums[i]){
                    cur.add(nums[i]);
                    visited.add(nums[i]);
                    dfs(nums, res, cur, i+1);
                    cur.remove(cur.size()-1);
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,7,7};
        LC491_findSubsequences L = new LC491_findSubsequences();
        List<List<Integer>> res = L.findSubsequences(nums);
        System.out.println(res.toString());
    }
}
