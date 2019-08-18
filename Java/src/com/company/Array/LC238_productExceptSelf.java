package com.company.Array;

public class LC238_productExceptSelf {
    public int[] productExceptSelf(int[] n) {
        /*
            explaination

            n :    1      2   3       4
        left  :    1      1  1*2*3  1*2*3*4
        right : 4*3*2*1  4*3  4*1      1
        */
        int[] left = new int[n.length];
        left[0] = 1;
        for(int i = 1; i < left.length; i++){
            left[i] = left[i-1] * n[i-1];
        }

        int[] res = new int[n.length];
        int right = 1;
        for(int i = n.length-1; i >= 0; i--){
            res[i] = left[i] * right;
            right = right * n[i];
        }
        return res;
    }
}
