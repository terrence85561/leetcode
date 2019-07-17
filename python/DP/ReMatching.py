class Solution:
    # leetcode: 10 re matching
    def isMatch(self, s, p):
        slen = len(s)
        plen = len(p)
        dp = [[False for i in range(0,plen + 1)] for j in range(0,slen+1)  ]
        dp[0][0] = True
        for i in range(2,plen+1):
            if p[i-1]=='*':
                dp[0][i] = dp[0][i-2]
        for i in range(1,slen+1):
            for j in range(1,plen+1):
                if s[i-1] == p[j-1] or p[j-1]=='.':
                    dp[i][j] = dp[i-1][j-1]
                elif p[j-1] == '*':
                    # the char before '*' appears 0 times
                    if p[j-2] != s[i-1] and p[j-2] != '.':
                        dp[i][j] = dp[i][j-2]
                    else:
                        dp[i][j] = dp[i][j-2] or dp[i][j-1] or dp[i-1][j]
                        #dp[i][j-2]: the char before '*' appears 0 times
                        #dp[i][j-1]: the char before '*' appears 1
                        #dp[i-1][j]: the char before '*' appears multiple times

        return dp[slen][plen]
                        
