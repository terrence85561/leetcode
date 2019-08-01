package com.company.String;

public class LC459_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        /*
            first try, O(n^2) in worst case
            or kmp?
         */
        int size = s.length();
        int mid = size / 2;
        for(int i = mid; i >= 1; i--){
            if(size % i == 0){
                int j = 0;
                while(j <= size-2*i){
                    if(!s.substring(j,j+i).equals(s.substring(j+i,j+2*i))) break;
                    j+=i;
                }
                if(j > size - 2*i) return true;
            }
        }
        return false;
    }
}
