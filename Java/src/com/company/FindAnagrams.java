package com.company;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;

/*
leetcode 438
hashtable
sliding window
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if(s==null||p==null||s.length()<p.length()) return result;

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] hash = new int[26];

        for(int i = 0; i < pArr.length; i++){
            hash[pArr[i] - 'a']++;
        }

        int pLength = p.length();
        int l = 0;
        int count = 0;

        for(int i = 0; i < sArr.length; i++){
            hash[sArr[i] - 'a']--;
            if(hash[sArr[i]]==0) count++;
            
        }


        return result;
    }
    public static void main(String[] args) {
	// write your code here
       FindAnagrams F = new FindAnagrams();
       F.findAnagrams("a","b");
    }
}
