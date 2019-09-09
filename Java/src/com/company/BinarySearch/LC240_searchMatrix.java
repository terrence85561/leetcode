package com.company.BinarySearch;

public class LC240_searchMatrix {
    public boolean searchMatrix(int[][] m, int target) {
        /*
            find a unique position: m[0][k]
            where all elements on its left are less and all elements on its bottom are larger
            begin searching from this position
        */

        if(m == null || m.length == 0) return false;
        int col_size = m[0].length;
        int row_size = m.length;

        int col = col_size - 1;
        int row = 0;

        while(col >= 0 && row < row_size){
            if(m[row][col] == target) return true;
            else if(m[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
