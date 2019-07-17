class Solution:
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        leetcode : 72 edit distance
        """
        #solve with DP
        w1Len = len(word1)
        w2Len = len(word2)
        dp = [[0 for i in range(0,w2Len + 1)]for j in range(0,w1Len + 1)]
        #base case:
        #   1 ' ' --> word2
        #   2 word1 --> ' '
        for i in range (0,w2Len + 1):
            dp[0][i] = i
        for i in range (0,w1Len + 1):
            dp[i][0] = i

        #update function:
        for i in range(1,w1Len + 1):
            for j in range(1,w2Len + 1):
                # if the char in current position of w1 equals to the char
                # in current position of w2, the number of operation is determined
                # by the previous condition
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    # find min between insert,delete and replace operation
                    # insert = dp[i-1][j-1]+1
                    # delete = dp[i-1][j]+1
                    # replace = dp[i][j-1]+1
                    dp[i][j] = min(min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1
        #goal
        return dp[w1Len][w2Len]






S = Solution()
word1 = 'e'
word2 = 'inten'
output = S.minDistance(word1,word2)
print(output)
