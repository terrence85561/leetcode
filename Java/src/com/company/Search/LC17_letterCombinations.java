package com.company.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    search
    dfs
    backtracking
 */
public class LC17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> num_map = new HashMap<>();
        num_map.put('2',"abc");
        num_map.put('3',"def");
        num_map.put('4',"ghi");
        num_map.put('5',"jkl");
        num_map.put('6',"mno");
        num_map.put('7',"pqrs");
        num_map.put('8',"tuv");
        num_map.put('9',"wxyz");

        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;

        char[] cur = new char[digits.length()];
        dfs(digits, num_map, cur, res, 0);
        return res;

    }

    public void dfs(String digits, HashMap<Character, String> dict, char[] cur, List<String> res, int idx){
        if(idx == digits.length()){
            res.add(new String(cur));
            return;
        }
        for(char c : dict.get(digits.charAt(idx)).toCharArray()){
            cur[idx] = c;
            dfs(digits, dict, cur, res, idx+1);
        }
    }

    public static void main(String[] args) {
        String digits = "";
        LC17_letterCombinations L = new LC17_letterCombinations();
        List<String> res = L.letterCombinations(digits);
        System.out.println(res);
    }
}
