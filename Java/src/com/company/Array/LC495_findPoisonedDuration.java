package com.company.Array;

public class LC495_findPoisonedDuration {
    public int findPoisonedDuration(int[] t, int d) {
        if(t == null || t.length == 0) return 0;
        if(t.length == 1) return d;
        int res = 0;
        for(int i = 1; i < t.length; i++){
            if(t[i] - t[i-1] >= d){
                res += d;
            }else{
                res += t[i]-t[i-1];
            }
        }
        res += d;
        return res;
    }
}
