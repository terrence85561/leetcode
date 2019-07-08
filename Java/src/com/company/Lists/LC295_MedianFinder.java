package com.company.Lists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC295_MedianFinder {
    private int counter;
    private PriorityQueue<Integer> minHeap, maxHeap;

    public LC295_MedianFinder() {
        counter = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        int max_top = get_max_top();

        if(counter % 2 == 0){
            if(num < max_top){
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }else{
                minHeap.offer(num);
            }
        }else{
            if(num < max_top){
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
        }
        counter ++;
    }

    public double findMedian() {
        if(counter == 0) return 0;
        else if (counter == 1) return minHeap.peek();
        else{
            if(counter % 2 == 0) return (minHeap.peek() + maxHeap.peek()) / 2.0;
            else{
                return minHeap.peek();
            }
        }
    }

    private int get_max_top(){
        if(maxHeap.isEmpty()) return Integer.MIN_VALUE;
        return maxHeap.peek();
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String[] args) {
        LC295_MedianFinder L = new LC295_MedianFinder();
        L.addNum(-1);
        L.addNum(-2);
        L.addNum(-3);
        System.out.println(L.findMedian());
    }
}
