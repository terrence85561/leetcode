package com.company.DynamicProgramming;

public class LC474_findmaxform_knapsack {
    public int findMaxForm(String[] strs, int m, int n) {
        /*
            time : O(kl + kmn)
            space : O(kmn)
            k : the length of string array
            l : the average length of each string in string array
            m : numbers of '0'
            n : numbers of '1'

            dp[i][j][k] : maximum number we can get from the first i strings in strs using j '0' and k '1'

         */

        int l = strs.length;

        int[][][] dp = new int[l+1][m+1][n+1];
        int[] nums = new int[]{0, 0};
        for(int i = 0; i < l+1; i++){
            if(i>0) nums = counts(strs[i-1]);
            for(int j = 0; j < m+1; j++){
                for(int k = 0; k < n+1; k++){
                    if(i==0) dp[i][j][k] = 0;
                    else{
                        if(j >= nums[0] && k >= nums[1]){
                            dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-nums[0]][k-nums[1]]+1);
                        }else{
                            dp[i][j][k] = dp[i-1][j][k];
                        }
                    }
                }
            }
        }
        return dp[l][m][n];
    }

    private int[] counts(String s){
        int[] res = new int[]{0, 0};
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') res[0]++;
            else if(s.charAt(i) == '1') res[1]++;
        }
        return res;
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        /*
            time : O(kl + kmn)
            space : O(mn)
            k : the length of string array
            l : the average length of each string in string array
            m : numbers of '0'
            n : numbers of '1'
         */



        int[][] dp = new int[m+1][n+1];
        int[] nums = new int[]{0, 0};
        for(String s : strs){
            nums = counts(s);
            for(int j = m; j >= nums[0]; j--){
                for(int k = n; k >= nums[1]; k--){
                    if( j >= nums[0] && k >= nums[1]){
                        dp[j][k] = Math.max(dp[j-nums[0]][k-nums[1]]+1, dp[j][k]);
                    }
                }
            }
        }
        return dp[m][n];
    }




}
