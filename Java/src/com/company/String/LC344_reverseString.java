package com.company.String;

public class LC344_reverseString {
    public void reverseString(char[] s) {
        int lo = 0;
        int hi = s.length-1;
        char c;

        while(lo < hi){
            c = s[lo];
            s[lo++] = s[hi];
            s[hi--] = c;
        }
    }
}
