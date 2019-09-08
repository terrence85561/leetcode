package com.company.Array;

public class LC36_isValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            int[] valid = new int[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(valid[board[i][j] - '1'] < 1){
                    valid[board[i][j] - '1']++;
                }else{
                    return false;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            int[] valid = new int[9];
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.') continue;

                if(valid[board[j][i] - '1'] < 1){
                    valid[board[j][i] - '1']++;
                }else{
                    return false;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            int[] valid = new int[9];
            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 3; col++){
                    if(board[row+3*(i/3)][col+3*(i%3)] == '.') continue;

                    if(valid[board[row+3*(i/3)][col+3*(i%3)] - '1'] < 1){
                        valid[board[row+3*(i/3)][col+3*(i%3)] - '1']++;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
