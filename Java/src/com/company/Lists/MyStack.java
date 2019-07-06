package com.company.Lists;


import java.util.LinkedList;
import java.util.Queue;

/*
    LC225
 */
public class MyStack {

    Queue<Integer> q1, q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 2 -> 1 2 -> 1 -> 3 3->2->1
        q1.offer(x);
        int q1_size = q1.size();
        int counter = 0;
        while(counter < q1_size-1){
            q1.offer(q1.poll());
            counter++;
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty()) return true;
        else return false;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
