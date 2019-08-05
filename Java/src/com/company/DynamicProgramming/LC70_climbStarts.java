package com.company.DynamicProgramming;

public class LC70_climbStarts {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return n;
        // init
        int[] dp = new int[n];
        dp[0] = 1;
        if(n >= 1) dp[1] = 2;

        // transition
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }
}
