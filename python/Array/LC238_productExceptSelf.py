    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # imagine when looping from left to right, in a certain view, we can only know the product of the values on the left
        # in order to knnow the product of values on the right from this view, just loop from right to left again
        
        # space O(1)
#         rtn = [1] * len(nums)
#         prod = 1        
#         for i in range(len(nums)):
#             rtn[i] *= prod
#             prod *= nums[i]
        
#         prod = 1
#         for i in range(len(nums)-1, -1, -1):
#             rtn[i] *= prod
#             prod *= nums[i]
            
#         return rtn
        
        # space O(n)
        left = [0] * len(nums)
        right = [0] * len(nums)
        left[0] = 1
        right[-1] = 1
        for i in range(1, len(nums)):
            left[i] = left[i-1] * nums[i-1]
            
        for i in range(len(nums)-2, -1, -1):
            right[i] = right[i+1] * nums[i+1]
        
        
        rtn = [left[i] * right[i] for i in range(len(nums))]
        return rtn
