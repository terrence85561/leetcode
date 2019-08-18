package com.company.DynamicProgramming;

public class LC121_maxProfit {
    public int maxProfit(int[] p) {
        if(p.length == 0 || p.length == 1) return 0;
        int min = p[0];
        int[] dp = new int[p.length];
        dp[0] = 0;


        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], p[i] - min);
            if(p[i] < min) min = p[i];
        }

        return dp[p.length - 1];

    }
}
