package com.company.Array;

import java.util.ArrayList;
import java.util.List;

public class LC54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
            ugly solution
         */
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        if(matrix.length == 1){
            for (int i : matrix[0]){
                res.add(i);
            }
            return res;
        }
        int r_size = matrix.length;
        int c_size = matrix[0].length;


        boolean[][] lookup = new boolean[matrix.length][matrix[0].length];

        int row = 0;
        int col = 0;
        lookup[row][col] = true;
        res.add(matrix[row][col]);
        while(true){

            while(col+1 < c_size && !lookup[row][col+1]){
                col = col+1;
                lookup[row][col] = true;
                res.add(matrix[row][col]);
            }
            while(row+1 < r_size && !lookup[row+1][col]){
                row = row+1;
                lookup[row][col] = true;
                res.add(matrix[row][col]);
            }
            while(col-1 >= 0 && !lookup[row][col-1]){
                col = col-1;
                lookup[row][col] = true;
                res.add(matrix[row][col]);
            }
            while(row - 1 >= 0 && !lookup[row-1][col]){
                row = row-1;
                lookup[row][col] = true;
                res.add(matrix[row][col]);
            }

            if(row > 0 && row < r_size-1 && col > 0 && col < c_size-1 && lookup[row-1][col] && lookup[row][col-1] && lookup[row+1][col] && lookup[row][col+1]) break;

            if(col == 0 && col < c_size-1 && row > 0 && lookup[row-1][col] && lookup[row][col+1]) break;

            if(col == c_size - 1 && row > 0 && lookup[row-1][col]) break;
        }

        return res;
    }
}
