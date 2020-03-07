class Solution:
        # def findTargetSumWays(self, nums: List[int], S: int) -> int:
        #     # dp O(n*l) where n is the size of nums, l is 2*offset+1
        #     # space O(n*l)
        # offset = 0
        # for num in nums:
        #     offset += num
        # if offset < S:
        #     return 0

        # dp = [[0 for i in range(2*offset+1)] for j in range(len(nums)+1)]

        # dp[0][offset] = 1
        # for i in range(1, len(nums)+1):
        #     for j in range(2*offset+1):
        #         if j-nums[i-1] >= 0:
        #             dp[i][j] += dp[i-1][j-nums[i-1]]
        #         if j+nums[i-1] <= 2*offset:
        #             dp[i][j] += dp[i-1][j+nums[i-1]]
        # return dp[len(nums)][S+offset]
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        # recursion with memorization
        # bottom up
        # Time complexity : O(l*n)O(l∗n). The memomemo array of size l*nl∗n has been filled just once. Here, ll refers to the range of sumsum and nn refers to the size of numsnums array.
        offset = 0
        for num in nums:
            offset += num

        memo = [[-1 for i in range(2*offset+1)] for j in range(len(nums))]

        def helper(nums, start, cur_sum, s, offset, memo):
            if(start == len(nums)):
                if cur_sum == s:
                    return 1
                else:
                    return 0
            else:
                if memo[start][cur_sum+offset] != -1:
                    return memo[start][cur_sum+offset]
                num = nums[start]
                add = helper(nums, start+1, cur_sum+num, s, offset,  memo)
                sub = helper(nums, start+1, cur_sum-num, s, offset, memo)
                memo[start][cur_sum+offset] = add+sub
                return memo[start][cur_sum+offset]
        return helper(nums, 0, 0, S, offset, memo)
    # def findTargetSumWays(self, nums: List[int], S: int) -> int:
    #     # brute force solution, recursion O(2^n) time
    #     # top-down
    #     # LTE in python
    #     def helper(nums, s, end):
    #         if end < -1:
    #             return 0
    #         if end == -1 and s != 0:
    #             return 0
    #         if end == -1 and s == 0:
    #             return 1

    #         num = nums[end]
    #         return helper(nums, s+num, end-1)+helper(nums, s-num, end-1)

    #     return helper(nums, S, len(nums)-1)

