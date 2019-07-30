package com.company.String;

import java.util.Stack;

public class LC20_isValid {
    public boolean isValid(String s) {
        if( s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (s.charAt(i) == '[') stack.push(']');
            else{
                if(stack.isEmpty() || stack.pop() != s.charAt(i)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
