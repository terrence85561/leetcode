package com.company.Graph;

public class LC200_numIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        int size_x = grid.length;
        if(size_x == 0) return 0;
        int size_y = grid[0].length;

        for(int i = 0; i < size_x; i++){
            for(int j = 0; j < size_y; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }

        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') return;
        grid[x][y] = '2';
        dfs(grid, x-1, y);
        dfs(grid, x+1, y);

        dfs(grid, x, y-1);
        dfs(grid, x, y+1);


    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        LC200_numIslands L = new LC200_numIslands();
        System.out.println(L.numIslands(grid));
    }
}
