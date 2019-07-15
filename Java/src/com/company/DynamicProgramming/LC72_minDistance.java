package com.company.DynamicProgramming;

public class LC72_minDistance {
    public int minDistance(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        if(size1 == 0) return size2;
        if(size2 == 0) return size1;

        // init
        int[][] dist = new int[size1 + 1][size2 + 1];
        for(int i = 0; i <= size2; i++) dist[0][i] = i;
        for(int i = 1; i <= size1; i++) dist[i][0] = i;

        // transition
        for(int i = 1; i <= size1; i++){
            for(int j = 1; j <= size2; j++){
                dist[i][j] = Integer.MAX_VALUE;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dist[i][j] = Math.min(Math.min(dist[i-1][j-1], dist[i-1][j] + 1), dist[i][j-1] + 1);
                }else{
                    dist[i][j] = Math.min(Math.min(dist[i-1][j-1], dist[i-1][j]),dist[i][j-1]) + 1;
                }
            }
        }


        return dist[size1][size2];

    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        LC72_minDistance L = new LC72_minDistance();
        System.out.println(L.minDistance(word1, word2));
    }
}
