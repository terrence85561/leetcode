package com.company.SlidingWindow;
/*
leetcode 76 sliding window; two ptr; hash table; string; hard;
 */
public class MinWindow {
    public String minWindow(String s, String t){

        // corner case
        if (s==null || t==null || s.length()<t.length()) return "";

        // create hash
        int[] hash = new int[256];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int tLength = tArr.length;
        int sLength = sArr.length;

        for(int i = 0; i < tLength; i++){
            hash[tArr[i]]++;
        }

        // sliding window
        int l = 0;
        int counter = 0;
        int minLength = sLength;
        String res = "";

        for(int i = 0; i < sLength; i++){
            hash[sArr[i]]--;
            if(hash[sArr[i]] >= 0){
                counter++;
            }
            // when the char in t appear again, move the left ptr
            while(i>l && hash[sArr[l]]<0){
                hash[sArr[l]]++;
                l++;
            }
            if(counter==tLength && i-l+1<=minLength){
                minLength = i-l+1;
                res = s.substring(l,i+1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        MinWindow M = new MinWindow();
        String s = "ABECODEBANAC";
        String t = "ABC";
        System.out.println(M.minWindow(s, t));

    }
}
