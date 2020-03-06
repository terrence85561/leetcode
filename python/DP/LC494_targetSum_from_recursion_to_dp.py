class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        # recursion with memorization
        # bottom up
        # Time complexity : O(l*n)O(l∗n). The memomemo array of size l*nl∗n has been filled just once. Here, ll refers to the range of sumsum and nn refers to the size of numsnums array.
        memo = [[-1 for i in range(2001)] for i in range(len(nums))]

        def helper(nums, s, start, cur_sum, memo):
            if start == len(nums):
                if(cur_sum == s):
                    return 1
                else:
                    return 0
            else:
                if memo[start][cur_sum+start] != -1:
                    return memo[start][cur_sum+start]
                num = nums[start]
                add = helper(nums, s, start+1, cur_sum+num, memo)
                sub = helper(nums, s, start+1, cur_sum-num, memo)
                memo[start][cur_sum+start] = add + sub
                return memo[start][cur_sum+start]

        return helper(nums, S, 0, 0, memo)
    # def findTargetSumWays(self, nums: List[int], S: int) -> int:
    #     # brute force solution, recursion O(2^n) time
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

