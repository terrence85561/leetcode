package com.company.Lists;

import java.util.Stack;

public class LC224_calculate {
    public int calculate(String s) {
            if(s == null || s.length() == 0) return 0;

            int sign = 1;
            int res = 0;

            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    int cur = c - '0';
                    while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                        cur = cur*10 + s.charAt(i+1) - '0';
                        i++;
                    }
                    res += cur * sign;
                }else if(c == '+'){
                    sign = 1;
                }else if(c == '-' ){
                    sign = -1;
                }else if (c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                }else if (c == ')'){
                    sign = stack.pop();
                    res = res * sign + stack.pop();
                    sign = 1;
                }

            }
            return res;
        }


    public static void main(String[] args) {
        LC224_calculate L = new LC224_calculate();
        int res = L.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(res);

    }
}
