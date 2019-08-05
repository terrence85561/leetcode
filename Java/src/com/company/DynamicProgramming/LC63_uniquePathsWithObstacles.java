package com.company.DynamicProgramming;

public class LC63_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] grids) {
        if(grids.length == 0 || grids[0].length == 0 ) return 0;
        int size_y = grids.length;
        int size_x = grids[0].length;

        // init
        int[][] dp = new int[size_y][size_x];
        dp[0][0] = grids[0][0] == 1 ? 0 : 1;
        for(int i = 1; i < size_y; i++){
            if(grids[i][0] == 1) break;
            dp[i][0] = dp[i-1][0];

        }

        for(int i = 1; i < size_x; i++){
            if(grids[0][i] == 1) break;
            dp[0][i] = dp[0][i-1];
        }

        // transition
        for(int i = 1; i < size_y; i++){
            for(int j = 1; j < size_x; j++){
                if(grids[i][j] == 1) continue;
                dp[i][j] = dp[i-1][j]  + dp[i][j-1];
            }
        }
        return dp[size_y-1][size_x-1];
    }
}
