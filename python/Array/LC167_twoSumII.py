class Solution:
    #      def twoSum(self, numbers: List[int], target: int) -> List[int]:
    #         # binary search O(nlogn) time O(1) space
    #         for i in range(len(numbers)-1):
    #             rest = target - numbers[i]
    #             match_idx = self.search(numbers, i+1, rest)
    #             if match_idx != -1:
    #                 res=[i+1, match_idx+1]
    #                 return res
    #         return res

    #     def search(self, numbers,start, target):
    #         l = start
    #         h = len(numbers)-1
    #         while(l<=h):
    #             m = l+(h-l)//2
    #             if(numbers[m] > target):
    #                 h = m-1
    #             elif(numbers[m] < target):
    #                 l = m+1

    #             else:
    #                 return m
    #         return -1
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # two pointer O(n) time O(1) space
        l = 0
        h = len(nums)-1
        while(l <= h):
            sums = nums[l]+nums[h]
            if(sums > target):
                h -= 1
            elif(sums < target):
                l += 1
            else:
                return [l+1, h+1]
        return -1
