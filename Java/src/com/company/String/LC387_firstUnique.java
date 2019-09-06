package com.company.String;

public class LC387_firstUnique {
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(hash[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;

    }
    /*
        using hashmap
        slower

     */
//    public int firstUniqChar(String s) {
//        if(s.length() == 0) return -1;
//        Map<Character, Integer> map = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            if(map.containsKey(s.charAt(i))){
//                map.put(s.charAt(i), s.length());
//            }else{
//                map.put(s.charAt(i), i);
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        for(Map.Entry<Character, Integer> entry : map.entrySet()){
//            if(entry.getValue() < min){
//                min = entry.getValue();
//            }
//        }
//        if(min == s.length()){
//            return -1;
//        }else{
//            return min;
//        }
//    }
}
