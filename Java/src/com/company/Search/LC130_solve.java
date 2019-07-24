package com.company.Search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC130_solve {
    private int size_x;
    private int size_y;
    public void solve(char[][] board) {

        size_x = board.length;
        if (size_x == 0) return;
        size_y = board[0].length;
        for (int i = 0; i < size_x; i++) {
            if (board[i][0] == 'O') {
                flood_fill(board, i, 0);
            }

            if (board[i][size_y - 1] == 'O') {
                flood_fill(board, i, size_y - 1);
            }
        }

        for (int i = 0; i < size_y; i++) {
            if (board[0][i] == 'O') {
                flood_fill(board, 0, i);
            }
            if (board[size_x - 1][i] == 'O') {
                flood_fill(board, size_x - 1, i);
            }
        }

        for(int i = 0; i < size_x; i++){
            for(int j = 0; j < size_y; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void flood_fill(char[][] board, int x, int y){
        if(x < 0 || x >= size_x || y < 0|| y >= size_y || board[x][y] != 'O') return;
        board[x][y] = '#';
        flood_fill(board, x-1, y);
        flood_fill(board, x+1, y);
        flood_fill(board, x, y-1);
        flood_fill(board, x, y+1);

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X','X','X',}, {'X', 'O', 'O','X'}, {'X','X', 'O','X'}, {'X', 'O', 'X','X'}};
        LC130_solve L = new LC130_solve();
        L.solve(board);
        for(int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }

    }
}
