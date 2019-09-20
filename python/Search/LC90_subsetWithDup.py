class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        cur = []
        self.dfs(nums, res, cur, 0)
        return res
    
    def dfs(self, nums, res, cur, start):
        res.append(cur[:])
        for i in range(start, len(nums)):
            if(i > start and nums[i] == nums[i-1]): continue
            cur.append(nums[i])
            self.dfs(nums, res, cur, i+1)
            cur.pop()