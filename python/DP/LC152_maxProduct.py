    def maxProduct(self, nums: List[int]) -> int:
#         high = nums[0]
        
#         for i in range(len(nums)):
#             res = nums[i]
#             for j in range(i+1, len(nums)):
#                 res *= nums[j]
#                 high = max(res, high)
#             high = max(nums[i], high)
#         return high

        
        dp = [()] * len(nums)
        dp[0] = (nums[0], nums[0])
        val = nums[0]
        
        for i in range(1, len(nums)):
            cur_max = max(nums[i], max(nums[i]*dp[i-1][0], nums[i]*dp[i-1][1]))
            cur_min = min(nums[i], min(nums[i]*dp[i-1][0], nums[i]*dp[i-1][1]))
            dp[i] = (cur_max, cur_min)
            val = max(cur_max, val)
            
        return val
