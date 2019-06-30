package com.company.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    search
    dfs
    backtracking
    Time O(4^n)
 */
public class LC17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        // corner case
        if(digits.isEmpty()) return new ArrayList<>();

        // create mapping for numbers and chars
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> result = new ArrayList<>();
        char[] curRes = new char[digits.length()];
        // using dfs to traverse the tree;
        dfs(digits, map, curRes, result, 1);
        return result;
    }

    private void dfs(String digits, HashMap<Character, String> map, char[] curRes, List<String> result, int level){
        // base case, if recurse to the leaf, push the curRes to result list, return.
        if(level > digits.length()){
            result.add(new String(curRes));
            return;
        }
        for(char c : map.get(digits.charAt(level-1)).toCharArray()){
            curRes[level-1] = c;
            dfs(digits, map, curRes, result, level+1);
        }

    }

    public static void main(String[] args) {
        String digits = "23";
        LC17_letterCombinations L = new LC17_letterCombinations();
        List<String> res = L.letterCombinations(digits);
        System.out.println(res);
    }
}
