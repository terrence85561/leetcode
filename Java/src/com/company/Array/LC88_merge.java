package com.company.Array;

public class LC88_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = 0;
        int idx2 = 0;

        int[] aux = new int[m];
        for(int i = 0; i < m; i++){
            aux[i] = nums1[i];
        }
        int idx = 0;
        while(idx1 < m && idx2 < n){
            if(aux[idx1] <= nums2[idx2]){
                nums1[idx++] = aux[idx1++];
            }else{
                nums1[idx++] = nums2[idx2++];
            }
        }
        while(idx1 < m){
            nums1[idx++] = aux[idx1++];
        }

        while(idx2 < n){
            nums1[idx++] = nums2[idx2++];
        }
    }
}
