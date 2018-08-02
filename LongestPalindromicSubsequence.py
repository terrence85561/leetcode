class Solution:
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        leetcode: 516. Longest Palindromic Subsequence
        """

        
        strLength = len(s)
        dp = [[0 for i in range(strLength)]for j in range(strLength)]
        for i in range(strLength):
            dp[i][i] = 1
        for i in range(2,strLength + 1):
            for j in range(0,strLength - i + 1):
                lsIdx = i + j - 1
                if s[j]==s[lsIdx] and i == 2:
                    dp[j][lsIdx] = 2
                elif s[j] == s[lsIdx]:
                    dp[j][lsIdx] = dp[j+1][lsIdx-1] + 2
                else:
                    dp[j][lsIdx] = max(dp[j+1][lsIdx],dp[j][lsIdx - 1])
        return dp[0][strLength - 1]
