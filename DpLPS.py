import numpy as np
class Solution:
#input = "abcdcbad"
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        begin = 0
        resLength = 1
        strLength = len(s)
        dp = np.zeros((strLength,strLength),dtype = bool)
        if not s or strLength == 0:
            return s

        # one char palindrome
        for i in range(0,strLength):
            dp[i,i] = True

        # two chars palindrome
        for i in range(0,strLength-1):
            if s[i] == s[i+1]:
                dp[i,i+1]=True
                resLength = 2
                begin = i

        # more than 3 chars palindrome
        for i in range(3,strLength+1):
            #traverse s
            for j in range(0,strLength-i+1):
                # compared index k
                k = j + i - 1
                if s[j] == s[k] and dp[j+1,k-1]:
                    dp[j,k] = True
                    if i > resLength:
                        begin = j
                        resLength = i

        return s[begin:resLength + begin]











S = Solution()
input = "cbbd"
output = S.longestPalindrome(input)
print(output)
