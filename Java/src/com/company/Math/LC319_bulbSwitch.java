package com.company.Math;

public class LC319_bulbSwitch {
    public int bulbSwitch(int n) {
//        boolean[] arr = new boolean[n];
//
//        for(int i = 1; i <= n; i++){
//            int j = -1;
//            while(j + i < n){
//                arr[j+i] = !arr[j+i];
//                j = j+i;
//            }
//        }
//        int cnt = 0;
//        for(int i = 0; i < n; i++){
//            if(arr[i]) cnt++;
//        }
//
//        return cnt;
        return (int)Math.sqrt(n);

    }

    public static void main(String[] args) {
        int n = 99999999;
        LC319_bulbSwitch L = new LC319_bulbSwitch();
        System.out.println(L.bulbSwitch(n));
    }
}
