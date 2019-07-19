package com.company.DynamicProgramming;

public class LC5_longestPalindrome {
    public String longestPalindrome(String s) {

        // corner case
        int size = s.length();
        if(size == 0 || size == 1 || s == null) return s;

        int max_length = 1;
        int lo = 0;
        // init
        boolean[][] isPali = new boolean[size][size];
        isPali[0][0] = true;
        for(int i = 1; i < size; i++){
            isPali[i][i] = true;


            if(s.charAt(i) == s.charAt(i-1)){
                isPali[i-1][i] = true;
                lo = i - 1;
                max_length = 2;
            }
        }

        // transition
        for(int j = 2; j < size; j++){
            for(int i = 0; i < j - 1; i++){
                if(s.charAt(i) == s.charAt(j) && isPali[i+1][j-1]){
                    if(j - i + 1 > max_length){
                        lo = i;
                        max_length = j - i + 1;
                    }
                    isPali[i][j] = true;
                }
            }
        }

        return s.substring(lo, lo+max_length);



    }

    public static void main(String[] args) {
        String s = "aaabcde";
        LC5_longestPalindrome L = new LC5_longestPalindrome();
        System.out.println(L.longestPalindrome(s));
    }
}
