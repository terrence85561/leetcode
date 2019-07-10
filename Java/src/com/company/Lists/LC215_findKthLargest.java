package com.company.Lists;

import java.util.PriorityQueue;
import java.util.Random;

public class LC215_findKthLargest {
//    public int findKthLargest(int[] nums, int k) {
//        /*
//            min heap; time O(n); space O(1)
//         */
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i = 0; i < nums.length; i++){
//            pq.offer(nums[i]);
//            if(pq.size() > k) pq.poll();
//        }
//        return pq.peek();
//    }
public int findKthLargest(int[] nums, int k) {
    shuffle(nums);
    int size = nums.length;
    int lo = 0, hi = size - 1;
    while(lo <= hi){
        int j = partition(nums, lo, hi);
        if(k == size - j) return nums[j];
        else if(k > size - j) hi = j - 1;
        else if(k < size - j) lo = j + 1;
    }
    return 0;
}


    private int partition(int[] a, int lo, int hi){
        int pivot = lo;
        int i = pivot;
        int j = hi + 1;
        if(lo == hi) return lo;
        while(true){
            while(a[++i] < a[pivot]){
                if(i == hi) break;
            }
            while(a[--j] > a[pivot]){
                if(j == lo) break;
            }

            if(i >= j){
                swap(a, pivot, j);
                pivot = j;
                return pivot;
            }
            swap(a,i ,j);
        }
    }

    private void shuffle(int[] a){
        Random rand = new Random();
        for(int i = 1; i < a.length; i++){
            int j = rand.nextInt(i);
            swap(a, i, j);
        }
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public static void main(String[] args) {
        LC215_findKthLargest L = new LC215_findKthLargest();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = L.findKthLargest(nums, k);
        System.out.println(res);
    }
}
