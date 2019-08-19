package com.company.Array;

import com.company.Search.LC491_findSubsequences;

import java.util.*;

public class LC49_groupAnagram {
    public List<List<String>> groupAnagrams(String[] s) {
        if (s.length == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : s){
            char[] sArr = str.toCharArray();
            Arrays.sort(sArr);
            String key = new String(sArr);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> cur = new ArrayList<>();
                cur.add(str);
                res.add(cur);
                map.put(key, cur);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        LC49_groupAnagram L = new LC49_groupAnagram();
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println( L.groupAnagrams(s));

    }
}
