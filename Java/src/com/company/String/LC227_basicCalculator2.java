package com.company.String;

import java.util.Stack;

public class LC227_basicCalculator2 {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                cur = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    cur = cur * 10 + s.charAt(i+1) - '0';
                    i++;
                }
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                if( sign == '+' ){
                    stack.push(cur);
                }else if( sign == '-' ){
                    stack.push(-cur);
                }else if( sign == '*' ){
                    stack.push(stack.pop() * cur);
                }else if( sign == '/' ){
                    stack.push(stack.pop() / cur);
                }
                cur = 0;
                sign = c;
            }
        }
        int res = 0;
        for(Integer i : stack){
            res += i;
        }
        return res;

    }
}
