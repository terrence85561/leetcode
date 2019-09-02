package com.company.Recursion;

import java.util.HashMap;

public class LC91_numDecoding {
    private HashMap<Integer, Integer> mem;
    public int numDecodings(String s) {
        /*
            recursion with memorization
        */
        if(s.length() == 0) return 0;
        mem = new HashMap<>();
        return helper(s, 0, s.length()-1);

    }
    private int helper(String s, int l, int r){
        if(mem.containsKey(l)) return mem.get(l);
        if(l < s.length() && s.charAt(l) == '0') return 0;
        if(l >= r) return 1;

        int cnt = helper(s, l+1, r);
        int prefix = (s.charAt(l) - '0') * 10 + (s.charAt(l+1) - '0');
        if(prefix <= 26){
            cnt += helper(s, l+2, r);
        }

        mem.put(l, cnt);
        return cnt;
    }
}
