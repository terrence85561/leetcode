class Solution:
    def maxProfit(self, prices: List[int]) -> int:
#        O(n^2) TLE
#         m = float('-inf')
#         for i in range(len(prices)-1):
#             for j in range(i+1, len(prices)):
#                 m = max(m, prices[j] - prices[i])
#         if m > 0:
#             return m
        
#         return 0
#       O(n)
        m = float('inf')
        res = 0
        for i in range(len(prices)):
            m = min(m, prices[i])
            res = max(res, prices[i] - m)
        return res