package com.company.Lists;


import java.util.Stack;

public class LC155_minStack {
    private Stack<Integer> origin;
    private Stack<Integer> mins;
    /** initialize your data structure here. */
    public LC155_minStack() {
        origin = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        origin.push(x);
        if(mins.isEmpty() || x < mins.peek()){
            mins.push(x);
        }else{
            mins.push(mins.peek());
        }
    }

    public void pop() {
        origin.pop();
        mins.pop();
    }

    public int top() {
        return origin.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
