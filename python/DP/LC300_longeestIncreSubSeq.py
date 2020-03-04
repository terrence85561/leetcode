class Solution:
    def lengthOfLIS(self, ns: List[int]) -> int:
        # first, think recursively:
        # LIS(ns, 0, len(ns)-1) = max(LIS(ns, 0, len(ns)-1), LIS(ns, 0, len(ns)-2)...)
        # then we can create a array, to store the result of each recursion.
        n = len(ns)
        if n == 0:
            return 0
        dp = [1] * n
        for i in range(1, n):
            for j in range(0, i):
                if ns[i] > ns[j]:
                    dp[i] = max(dp[j]+1, dp[i])

        return max(dp)
