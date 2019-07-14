package com.company.Graph;

public class LC547_findCircleNum {
    public int findCircleNum(int[][] M) {
        int size = M.length;
        if(size == 0) return 0;
        int[] visited = new int[size];
        int res = 0;
        for(int i = 0; i < size; i++){
            if(visited[i] == 0){
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int[] visited, int i){
        for(int j = 0; j < M.length; j++){
            if(visited[j] == 0 && M[i][j] == 1){
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        LC547_findCircleNum L = new LC547_findCircleNum();
        int[][] M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int res = L.findCircleNum(M);
        System.out.println(res);
    }
}
