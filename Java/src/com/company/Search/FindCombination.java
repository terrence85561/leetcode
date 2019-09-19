package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class FindCombination {
    public List<List<Character>> findCombination(String digits, int select) {
        List<List<Character>> res = new ArrayList<>();
        List<Character> cur = new ArrayList<>();
        dfs(digits, select, res, cur, 0, 0);
        return res;
    }
    private void dfs(String digits, int select, List<List<Character>> res, List<Character> cur, int level, int start){
        if(level == select){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < digits.length(); i++){
            cur.add(digits.charAt(i));
            dfs(digits, select, res, cur, level+1, i+1);
            cur.remove(cur.size()-1);
        }
    }


    public static void main(String[] args) {
        FindCombination F = new FindCombination();
        String digits = "123";
        int select = 2;
        System.out.println(F.findCombination(digits, select));
    }
}
