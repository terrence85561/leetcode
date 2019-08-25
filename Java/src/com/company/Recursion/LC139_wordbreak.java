package com.company.Recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC139_wordbreak {
    private HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
            recursion with memorization
            https://www.youtube.com/watch?v=ptlwluzeC1I
            recursively solve the left part of the input s
            determine if the right part is in wordDict
            store the intermediate result in a hashmap
        */
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        return wordBreak(s, set);
    }

    private boolean wordBreak(String s, HashSet<String> set){
        if(s.length() == 0) return true;
        if(map.containsKey(s)) return map.get(s);
        if(set.contains(s)){
            return true;
        }

        for(int i = 1; i < s.length(); i++){
            String l = s.substring(0, i);
            String r = s.substring(i, s.length());
            if(set.contains(r) && wordBreak(l, set)){
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
