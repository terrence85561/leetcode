package com.company.DynamicProgramming;

public class LC322_CoinChange {
    public int coinChange(int[] coins, int amount){
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i = 0; i <= coins.length; i++){
            for (int j = 0; j <= amount; j++){
                dp[i][j] = amount+1;
            }
        }

        for (int i = 0; i <= coins.length; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount]==(amount+1) ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        LC322_CoinChange L = new LC322_CoinChange();
        int res = L.coinChange(coins, amount);
        System.out.println(res);
    }
}
