class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.dfs(res, "", n, 0, 0)
        return res

    def dfs(self, res, cur, n, left, right):
        if left < right:
            return

        if(left == n and right == n):
            res.append(cur)
            return
        if left < n:
            self.dfs(res, cur+'(', n, left+1, right)
        if right < n:
            self.dfs(res, cur + ')', n, left, right+1)
