package com.company.Math;

public class LC396_maxRotateFunction {
    public int maxRotateFunction(int[] A) {
        int f = 0;
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            f += i * A[i];
            sum += A[i];
        }

        int max = f;
        for(int i = 1; i < A.length; i++){
            f = f - sum + A.length * A[i-1];
            if(f > max) max = f;
        }

        return max;

    }
}
