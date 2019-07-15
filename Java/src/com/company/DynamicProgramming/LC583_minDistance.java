package com.company.DynamicProgramming;

public class LC583_minDistance {
    public int minDistance(String word1, String word2) {
        int size1 = word1.length();
        int size2 = word2.length();
        int[][] dist = new int[size1 + 1][size2 + 1];
        if(size1 == 0) return size2;
        if(size2 == 0) return size1;

        // init
        for(int i = 0; i <= size2; i++) dist[0][i] = i;
        for(int i = 1; i <= size1; i++) dist[i][0] = i;

        // transition
        for(int i = 1; i <= size1; i++){
            for(int j = 1; j <= size2; j++){
                dist[i][j] = Integer.MAX_VALUE;
                int c = (word1.charAt(i-1) == word2.charAt(j-1)) ? 0 : 2;
                dist[i][j] = Math.min(dist[i-1][j-1] + c, Math.min(dist[i-1][j], dist[i][j-1]) + 1);
            }
        }

        return dist[size1][size2];

    }

    public static void main(String[] args) {
        LC583_minDistance L = new LC583_minDistance();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(L.minDistance(word1, word2));
    }

}
