package com.company.Lists;

import java.util.Stack;

/*
    LC232
 */
public class MyQueue {
    /** Initialize your data structure here. */
    private Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
//        s2 = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
//        s1.push(x);
        s2 = new Stack<>();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
//        if(!s2.isEmpty()) return s2.pop();
//        while(!s1.isEmpty()){
//            s2.push(s1.pop());
//        }
//        return s2.pop();
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
//        if(!s2.isEmpty()) return s2.peek();
//        while(!s1.isEmpty()){
//            s2.push(s1.pop());
//        }
//        return s2.peek();
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
//        if(s1.isEmpty() && s2.isEmpty()) return true;
//        return false;
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */