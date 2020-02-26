class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        size_x = len(board[0])
        size_y = len(board)

        for i in range(size_x):
            for j in range(size_y):
                if self.dfs(board, word, i, j, 0):
                    return True
        return False

    def dfs(self, board, word, x, y, index):
        if(x < 0 or y < 0 or y >= len(board) or x >= len(board[0])):
            return False
        if(board[y][x] != word[index]):
            return False
        if(index == len(word)-1):
            return True

        cur = board[y][x]
        board[y][x] = '0'
        found = self.dfs(board, word, x+1, y, index+1) or self.dfs(board, word, x-1, y, index +
                                                                   1) or self.dfs(board, word, x, y+1, index+1) or self.dfs(board, word, x, y-1, index+1)
        board[y][x] = cur
        return found
