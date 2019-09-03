package com.company.Design;

import java.util.Iterator;
import java.util.Stack;

public class LC341_NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> st;
    public LC341_NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack<>();
        for(int i = nestedList.size()-1; i >= 0; i--){
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()){
            NestedInteger cur_peek = st.peek();
            if(cur_peek.isInteger()){
                return true;
            }
            st.pop();
            for(int i = cur_peek.getList().size()-1; i >= 0; i--){
                st.push(cur_peek.getList().get(i));
            }
        }
        return false;
    }
}
