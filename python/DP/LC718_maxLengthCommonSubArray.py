class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:

        size_a = len(A)
        size_b = len(B)
        if size_a == 0 or size_b == 0:
            return 0
        dp = [[0 for i in range(size_a+1)] for j in range(size_b+1)]
        max_length = 0
        for i in range(1, size_b+1):
            for j in range(1, size_a+1):
                if(A[j-1] == B[i-1]):
                    dp[i][j] = dp[i-1][j-1]+1
                    max_length = max(max_length, dp[i][j])
                else:
                    dp[i][j] = 0

        return max_length
