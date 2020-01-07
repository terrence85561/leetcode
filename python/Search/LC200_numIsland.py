"""
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
"""

def numIsland(grid):
    if len(grid) == 0:
        return 0

   

    res = 0
    for x in range(len(grid)):
        for y in range(len(grid[0])):
            if grid[x][y] == 1:
                dfs(grid, x, y)
                res += 1
    return res

def dfs(grid, x, y):
    if(x<0 or y<0 or x>=len(grid) or y >= len(grid[0]) or grid[x][y] != 1):
        return
    grid[x][y] = 2
    dfs(grid, x-1, y)
    dfs(grid, x+1, y)
    dfs(grid, x, y-1)
    dfs(grid, x, y+1)


if __name__ == "__main__":
    grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,0,1,1]]
    print(numIsland(grid))
