package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class LC77_combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, k ,res, cur, 0, 0);
        return res;
    }

    private void dfs(int n, int select, List<List<Integer>> res, List<Integer>cur, int level, int start){
        // base case
        if(level == select){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < n; i++){
            cur.add(i+1);
            dfs(n, select, res, cur, level+1, i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        LC77_combination L = new LC77_combination();
        System.out.println(L.combine(n, k));
    }
}
