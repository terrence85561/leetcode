class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]

        """

        for i in range(0,len(nums)) :
            for j in range(0,len(nums)) :
                if i == j:
                    break
                else:
                    answer = nums[i] + nums[j]

                    if target == answer:
                        return(j,i)
        """
        for i in nums:
            if target - i in nums and i is not target - i:
                return(nums.index(i),nums.index(target - i))
        """
