package com.company.Math;

public class LC223_computeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int first_area = Math.abs(C-A) * Math.abs(D-B);
        int second_area = Math.abs(G-E) * Math.abs(H-F);

        if(C <= E || A >= G || B >= H || D <= F){
            return first_area + second_area;
        }else{
            int overlap = Math.abs(Math.min(D, H) - Math.max(B, F)) * Math.abs(Math.min(G, C) - Math.max(A, E));
            return first_area + second_area - overlap;
        }

    }
}
