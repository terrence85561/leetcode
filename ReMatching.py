class Solution:
    def isMatch(self, s, p):
        """
        :type s: original str
        :type p: match str
        :rtype: bool
        """
        start = 0
        sLen = len(s)
        pLen = len(p)

        dp = [[0 for i in range(0,sLen)]for j in range(0,pLen)]

        for i in range(0,sLen):
            for j in range(start,pLen):

                if s[i] == s[j] and dp[j-1][i-1]:
                    dp[j][i]=True
                    start = j






        return dp








S = Solution()
s = 'mississippi'
p = 'mis*is*p*.'
output = S.isMatch(s,p)
print(output)
