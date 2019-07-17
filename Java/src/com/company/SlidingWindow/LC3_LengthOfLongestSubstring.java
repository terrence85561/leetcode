package com.company.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC3_LengthOfLongestSubstring {
    /*
    leetcode 3
    sliding window
     */
    public int lengthOfLongestSubstring(String s) {
        // corner case
        if(s == null || s.length() == 0){
            return 0;
        }
        // create hash
        int[] hash = new int[256];
        char[] sArr = s.toCharArray();

        //sliding window
        int l = 0;
        int maxCount = 1;
        for(int i = 0; i < sArr.length; i++){
            hash[sArr[i]]++;
            while(hash[sArr[i]]>1){
                hash[sArr[l]]--;
                l++;
            }
            maxCount = Math.max(maxCount,i-l+1);
        }
        return maxCount;
    }


    public int lengthOfLongestSubstringWithHashMap(String s) {
        // corner case
        if(s == null || s.length() == 0) return 0;

        // create hashMap
        Map<Character, Integer> hash = new HashMap<>();
        char[] sArr = s.toCharArray();

        //sliding window
        int l = 0;
        int maxCount = 1;
        for(int i = 0; i < sArr.length; i++){
            if(hash.containsKey(s.charAt(i))){
                l = Math.max(l, hash.get(s.charAt(i))+1);
            }
            hash.put(sArr[i], i);
            maxCount = Math.max(maxCount, i - l + 1);
        }
        return maxCount;
    }

    public int lengthOfLongestSubstringWithHashSet(String s){
        // corner case
        if(s == null || s.length() == 0) return 0;

        // create hashset
        Set<Character> hash = new HashSet<>();

        // sliding window
        int l = 0;
        int maxCount = 1;
        for(int i = 0; i < s.length(); i++){
            while(hash.contains(s.charAt(i))){
                hash.remove(s.charAt(l++));
            }
            hash.add(s.charAt(i));
            maxCount = Math.max(maxCount, i - l + 1);
        }
        return maxCount;


    }


    public static void main(String[] args) {
        LC3_LengthOfLongestSubstring L = new LC3_LengthOfLongestSubstring();
        String s = "abcabcbb";
        int res = L.lengthOfLongestSubstringWithHashMap(s);
        System.out.println(res);
    }
}
