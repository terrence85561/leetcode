package com.company.Search;

import com.company.Lists.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LC39_combinationSum {
    /*
        lc 39
        backtracking
        dfs

     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, target, 0, res, temp);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> temp){
        // int start is to determine which index to start when traversing.
        // this is because of the output should not contain duplicates.

        // corner case
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        else if (target < 0) return;
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target) break;
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, res, temp);
            temp.remove(temp.size()-1);

        }
    }



    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        LC39_combinationSum C = new LC39_combinationSum();
        List<List<Integer>> res = C.combinationSum(candidates, target);
        System.out.println(res);
    }
}
