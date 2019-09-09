package com.company.Math;

import java.util.Arrays;

public class LC204_countPrimes {
    public int countPrimes(int n) {
        /*
            Let's write down all of 12's factors:

            2 × 6 = 12
            3 × 4 = 12
            4 × 3 = 12
            6 × 2 = 12
            As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. Therefore, we only need to consider factors up to √n because, if n is divisible by some number p,             then n = p × q and since p ≤ q, we could derive that p ≤ √n.
        */
        if(n < 1) return 0;
        int res = 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]) continue;
            int j = i;
            while(j + i <= n){
                isPrime[j+i] = false;
                j = j+i;
            }
        }
        for(int i = 2; i < n; i++ ){
            if(isPrime[i]) res++;
        }
        return res;
    }
}
