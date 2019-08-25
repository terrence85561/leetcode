package com.company.String;

import java.util.HashMap;

public class LC13_romanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if(s.length() == 0) return 0;
        if(s.length() == 1) return map.get(s.charAt(0));

        int res = map.get(s.charAt(0));
        char[] sArr = s.toCharArray();
        for(int i = 1; i < sArr.length; i++){
            if(map.get(sArr[i]) > map.get(sArr[i-1])){
                res = res + map.get(sArr[i]) - 2 * map.get(sArr[i-1]);
            }else{
                res = res + map.get(sArr[i]);
            }
        }
        return res;
    }
}
