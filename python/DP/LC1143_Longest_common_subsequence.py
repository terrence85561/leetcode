class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        size_1 = len(text1)
        size_2 = len(text2)
        dp = [[0 for j in range (size_1+1)] for i in range (size_2+1)]
        
        for i in range(1, size_2+1):
            for j in range(1, size_1+1):
                if text1[j-1] == text2[i-1]:
                    dp[i][j] = dp[i-1][j-1]+1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        return dp[size_2][size_1]