class Solution:
#input = "abcdcbad"

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        startIdx = 0
        resLength = 1
        strLength = len(s)
        dp = [[0 for i in range (strLength)]for j in range (strLength)]

        if not s or strLength == 1:
            return s

        for i in range (0,strLength):
            dp[i][i] = True

        for i in range (0,strLength-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = True
                startIdx = i
                resLength = 2

        for i in range (3,strLength + 1):
            for j in range (0,strLength - i + 1):
                k = j + i - 1
                if s[j] == s[k] and dp[j+1][k-1]:
                    dp[j][k] = True
                    if i > resLength:
                        startIdx = j
                        resLength = i

        return s[startIdx:resLength+startIdx]








S = Solution()
input = "cbbd"
output = S.longestPalindrome(input)
print(output)
