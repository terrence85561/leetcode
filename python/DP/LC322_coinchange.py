class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins or len(coins) == 0:
            return -1
        
        size_c = len(coins)
        dp  = [[0 for i in range(amount+1)] for j in range(size_c+1)]
        
        for i in range(amount+1):
            dp[0][i] = amount+1
        
        
        for i in range(1, size_c+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
        
        if dp[size_c][amount]>amount:
            return -1
        else:
            return dp[size_c][amount]