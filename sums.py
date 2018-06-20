class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]

        """
        """
        for i in range(0,len(nums)-1) :
            for j in range(0,len(nums)-1) :
                if nums[i] == nums[j]:
                    break
                else:
                    answer = nums[i] + nums[j]
                    if target == answer:
                        return(i,j)
        """
        for i in nums:
            if target - i in nums and i is not target - i:
                return(nums.index(i),nums.index(target - i))
nums = [ 2,4,6,7]
target = 13
s = Solution()
print(s.twoSum(nums,target))
