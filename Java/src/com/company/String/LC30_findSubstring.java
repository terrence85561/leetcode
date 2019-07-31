package com.company.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30_findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || words.length == 0 || words[0].length() > s.length() ) return res;
        Map<String, Integer> map = new HashMap<>();
        for(String str : words){
            if(map.containsKey(str)) map.put(str, map.get(str)+1);
            else map.put(str, 1);
        }

        int word_size = words[0].length();
        for(int i = 0; i <= s.length() - word_size * words.length; i++ ){
            if(map.containsKey(s.substring(i, i+word_size))){
                Map<String, Integer> record = new HashMap<>();
                for(int j = i; j < i + word_size * words.length; j = j + word_size){
                    String str = s.substring(j, j+word_size);
                    if(!map.containsKey(str)) break;
                    if(record.containsKey(str)){
                        if(record.get(str) > map.get(str)) break;
                        record.put(str, record.get(str)+1);
                    }else{
                        record.put(str, 1);
                    }
                }
                if(record.equals(map)) res.add(i);
            }
        }
        return res;
    }
}
