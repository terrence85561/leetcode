class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # O(n) O(1) greedy, find local max then lead to glabal max
        #         cur_sum = nums[0]
        #         max_sum = cur_sum

        #         for i in range(1, len(nums)):
        #             cur_sum = max(cur_sum+nums[i], nums[i])
        #             max_sum = max(cur_sum, max_sum)

        #         return max_sum
        # dp

        res = nums[0]
        for i in range(1, len(nums)):
            if nums[i-1] > 0:
                nums[i] += nums[i-1]
            res = max(res, nums[i])
        return res
