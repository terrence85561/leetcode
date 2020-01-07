class Solution:
    mapping = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
    
    def letterCombinations(self, digits: str) -> List[str]:
        
        res = []
        if not digits or len(digits) == 0:
            return res
        self.dfs(digits, res, "", 0)
        return res
    
    def dfs(self, digits, res, cur, level):
            if level == len(digits):
                res.append(cur)
                return
            current_digit = int(digits[level])
            current_pad = self.mapping[current_digit]
            for i in range(len(current_pad)):
                self.dfs(digits, res, cur+current_pad[i], level+1)
                
            
            