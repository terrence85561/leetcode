package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class FindPermutation {
    public List<List<Character>> findPermutaion(String digits, int select ){
        List<List<Character>> res = new ArrayList<>();
        boolean[] used = new boolean[digits.length()];
        List<Character> cur = new ArrayList<>();
        dfs(digits, select, res, used, cur, 0);
        return res;
    }

    private void dfs(String digits, int select, List<List<Character>> res, boolean[] used, List<Character> cur, int level ){
        // base case
        if(level == select){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < digits.length(); i++){
            if(used[i] == true) continue;
            cur.add(digits.charAt(i));
            used[i] = true;
            dfs(digits, select, res, used, cur, level+1);
            cur.remove(cur.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        FindPermutation F = new FindPermutation();
        String digits = "123";
        int select = 3;
        List<List<Character>> res = F.findPermutaion(digits, select);
        System.out.println(res);
    }
}
