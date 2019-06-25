package com.company.TwoPointer;

import java.util.Stack;

/*
    lc 844 Backspace String compare
    two ptrs
    stacks
    Time : O(n)
    Space : O(1)?
 */
public class LC844_BackSpace {
    
    public boolean backspaceCompare(String S, String T){

        int si = S.length()-1;
        int ti = T.length()-1;

        int sBack = 0;
        int tBack = 0;

        while(si>=0 || ti>=0){

            while(si>=0 && (sBack>0 || S.charAt(si)=='#')){
                if(S.charAt(si)=='#'){
                    sBack++;
                }else{
                    sBack--;
                }
                si--;
            }
            char sChar, tChar;
            if(si>=0){
                sChar = S.charAt(si);
            }else{
                sChar = '@';
            }


            while(ti>=0 && (tBack>0 || T.charAt(ti)=='#')){
                if(T.charAt(ti)=='#'){
                    tBack++;
                }else{
                    tBack--;
                }
                ti--;
            }

            if(ti>=0){
                tChar = T.charAt(ti);
            }else{
                tChar = '@';
            }

            if(sChar!=tChar) return false;
            ti--;
            si--;
        }
        return true;

    }







    public boolean backspaceCompareWithStack(String S, String t){

        Stack<Character> s_stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c!='#'){
                s_stack.push(c);
            }else if(!(s_stack.isEmpty())){
                s_stack.pop();
            }
        }

        Stack<Character> t_stack = new Stack<>();
        for(char c : t.toCharArray()){
            if(c!='#'){
                t_stack.push(c);
            }else if(!(t_stack.isEmpty())){
                t_stack.pop();
            }
        }

        if(t_stack.equals(s_stack)) return true;
        else return  false;



    }

    public static void main(String[] args) {
        LC844_BackSpace B = new LC844_BackSpace();
        String s = "ab#";
        String t = "c#d#";
        boolean res = B.backspaceCompare(s, t);
        System.out.println(res);
    }
}
