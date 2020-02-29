class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        output = []
        for num in nums:
            if nums[abs(num)-1] < 0:
                output.append(abs(num))
            else:
                nums[abs(num)-1] *= -1

        return output
