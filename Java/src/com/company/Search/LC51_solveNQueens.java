package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class LC51_solveNQueens {
//    reference : https://zxi.mytechroad.com/blog/?s=queen
    private List<List<String>> res;
    private List<String> board;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append('.');
        }

        board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            board.add(sb.toString());
        }

        cols = new boolean[n];
        diag1 = new boolean[2*n-1];
        diag2 = new boolean[2*n-1];

        dfs(n, 0);

        return res;

    }

    private void dfs(int n, int y){
        if(y == n){
            res.add(new ArrayList<>(board));
            return;
        }

        for(int x = 0; x < n; ++x){
            if(!available(x, y, n)) continue;
            updateBoard(x, y, n, true);
            dfs(n, y+1);
            updateBoard(x, y, n, false);
        }
    }

    private boolean available(int x, int y, int n){
        return !cols[x] && !diag1[x+y] && !diag2[x-y+n-1];
    }

    private void updateBoard(int x, int y, int n, boolean is_put){
        cols[x] = is_put;
        diag1[x+y] = is_put;
        diag2[x-y+n-1] = is_put;
       char[] temp = board.get(y).toCharArray();
       temp[x] = is_put ? 'Q':'.';
       board.set(y, String.valueOf(temp));
    }
}
