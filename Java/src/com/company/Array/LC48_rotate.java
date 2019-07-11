package com.company.Array;

public class LC48_rotate {
    public void rotate(int[][] matrix) {
        /*
            a b c d
            e f g h
            i j k l
            m n o p

            a 0 0
              0 3

            b 0 1
              1 3

            c 0 2
              2 3

            d 0 3
              3 3

            e 1 0
              0 1
            f 1 1
              1 2
         */
        int size = matrix.length;
        boolean[][] status = new boolean[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(status[i][j] == false){
                    int counter = 0;
                    int row = i;
                    int col = j;
                    int last = matrix[row][col];
                    int cur;
                    while(counter < 4){
                        status[row][col] = true;
                        cur = matrix[col][size-1-row];
                        matrix[col][size-1-row] = last;
                        last = cur;
                        int newCol = size - 1 - row;
                        row = col;
                        col = newCol;
                        counter++;
                    }

                }else{
                    continue;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        LC48_rotate L = new LC48_rotate();
        L.rotate(matrix);
        System.out.println(matrix[2][2]);
    }
}
