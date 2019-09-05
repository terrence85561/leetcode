package com.company.Math;

public class LC50_myPow {
    public double myPow(double x, int n) {
        // BF:LTE
        // if(n == 0) return 1.0;
        // else if(n > 0){
        //     double res = 1;
        //     for(int i = 0; i < n; i++){
        //         res = res * x;
        //     }
        //     return res;
        // }else{
        //     double res = 1;
        //     n = -n;
        //     for(int i = 0; i < n; i++){
        //         res = res * x;
        //     }
        //     return 1/res;
        // }
        if(n == 0) return 1.0;
        if(n == 1) return x;
        else if(n > 1){
            double res = 1;
            while(n > 1){
                if( n % 2 == 1){
                    res *= x;
                }
                n /= 2.0;
                x = x * x;
            }
            res *= x;
            return res;
        }
        else{
            double res = myPow(x, -(n+1));
            return 1/(x*res);
        }
    }
}
