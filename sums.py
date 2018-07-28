class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        dict = {}
        for i in range (0,len(nums)):
            if (target - nums[i]) in dict:
                return(dict[target - nums[i]],i)
            dict[nums[i]] = i
        
