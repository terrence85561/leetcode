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

        //corner case
        if(s==null||p==null||s.length()<p.length()) return new ArrayList<>();
        // hash
        int[] hash = new int[26];
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        for (char c : p.toCharArray()){
            // store the frequency of each char in p
            hash[c - 'a']++;
        }

        // sliding window
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int counter = 0;
        for(int i = 0; i < sArr.length; i++){
            hash[sArr[i] - 'a']--;
            if(hash[sArr[i] - 'a']>=0) counter++;
            if(i > pArr.length - 1){
                hash[sArr[l] - 'a']++;
                if(hash[sArr[l] - 'a'] > 0){
                    counter--;
                }
                l++;
            }
            if(counter==pArr.length) result.add(l);
        }


        // return result
        return result;

    }
    public static void main(String[] args) {
	// write your code here
       FindAnagrams F = new FindAnagrams();
       List<Integer> res = F.findAnagrams("cbaebabacd","abc");
       System.out.println(res);
    }
}
