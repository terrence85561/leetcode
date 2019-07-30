package com.company.DynamicProgramming;

import java.util.List;

public class LC120_minimumTotal {
    public int minimumTotal1(List<List<Integer>> triangle) {
        /*
            O(n^2) space
         */
        if(triangle.size() == 1) return triangle.get(0).get(0);

        // init
        int level_size = triangle.size();
        int[][] dp = new int[level_size][level_size];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < level_size; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        // transition
        int res = dp[level_size-1][0];
        for(int i = 1; i < level_size; i++){
            for(int j = 1; j < i; j++ ){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);

            }
        }

        for(int i = 1; i < level_size; i++ ){
            res = Math.min(res, dp[level_size-1][i]);
        }
        return res;
    }

    public int minimumTotal(List<List<Integer>> tri) {
        /*
            O(n) space rolling array
         */

        if(tri.size() == 1) return tri.get(0).get(0);

        // init
        int size = tri.size();
        int[][] dp = new int[2][size+1];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < size+1; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[1][1] = tri.get(0).get(0);

        for(int i = 2; i <= size; i++){
            for(int j = 1; j <= i; j++){
                dp[i%2][j] = Math.min(dp[(i-1)%2][j], dp[(i-1)%2][j-1]) + tri.get(i-1).get(j-1);
            }

        }


        int res = dp[1][1];

        for(int i = 2; i <= size; i++){
            res = Math.min(res, dp[1][i]);
        }
        return res;

    }



}
