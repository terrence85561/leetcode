class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        size_a = amount
        size_c = len(coins)

        dp = [[0 for i in range(size_a+1)] for j in range(size_c+1)]
        for i in range(size_c+1):
            dp[i][0] = 1

        for i in range(1, size_c+1):
            for j in range(1, size_a+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]

                else:

                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]

        return dp[size_c][size_a]
