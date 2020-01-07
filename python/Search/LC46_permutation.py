class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        cur = []
        res = []
        used = [False for i in range(len(nums))]
        self.dfs(nums, res, cur, used, len(nums), 0, 0)
        return res

    def dfs(self, nums, res, cur, used, select, level, start):
        if (select == level):
            res.append([i for i in cur])
            return
        for i in range(len(nums)):
            if used[i]:
                continue
            cur.append(nums[i])
            used[i] = True
            self.dfs(nums, res, cur, used, select, level+1, i+1)
            cur.pop()
            used[i] = False
