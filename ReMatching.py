class Solution:
    def isMatch(self, s, p):
        sLen = len(s)
        pLen = len(p)
        dp = [[False for i in range(0,pLen+1)]for j in range(0,sLen+1)]
        dp[0][0] = True

        for i in range(2,pLen+1):
            if p[i-1] == '*' :
                dp[0][i] = dp[0][i-2]
        for i in range(1,sLen+1):
            for j in range(1,pLen+1):
                if s[i-1] == p[j-1] or p[j-1] == '.':
                    dp[i][j] = dp[i-1][j-1]
                elif p[j-1] == '*':
                    if p[j-2] != s[i-1] and p[j-2] != '.':
                        dp[i][j] = dp[i][j-2]
                    else:
                        dp[i][j] = dp[i][j-2] or dp[i][j-1] or dp[i-1][j]

        return dp[sLen][pLen]








S = Solution()
s = 'aab'
p = 'c*a*b'
output = S.isMatch(s,p)
print(output)
