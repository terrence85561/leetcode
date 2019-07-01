package com.company.Search;


import java.util.*;

public class LC40_combinatiionSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, res, cur, 0);
        return new ArrayList<>(res);

    }

    private void dfs(int[] candidates, int target, Set<List<Integer>> res, List<Integer> cur, int start){

        // base case
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        else if(target < 0) return;

        for(int i = start; i < candidates.length; i++){
            if(target < candidates[i]) break;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        LC40_combinatiionSumII C = new LC40_combinatiionSumII();
        List<List<Integer>> res = C.combinationSum2(candidates, target);
        System.out.println(res);
    }
}
