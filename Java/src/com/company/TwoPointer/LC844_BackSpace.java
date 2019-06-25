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
//    public boolean backspaceCompare(String S, String T) {
//        int sPtr = S.length()-1;
//        int tPtr = T.length()-1;
//        int sBack = 0;
//        int tBack = 0;
//        for(int si = S.length()-1, ti = T.length()-1; si>=0 || ti >=0; si--, ti--){
//            while(sPtr>0 && S.charAt(sPtr)=='#'){
//                sPtr--;
//            }
//            while(tPtr>0 && T.charAt(tPtr)=='#'){
//                tPtr--;
//            }
//
//            if(S.charAt(si)=='#'){
//                sBack++;
//            }
//            if(T.charAt(ti)=='#'){
//                tBack++;
//            }
//
//            while(sBack>0 && sPtr>=0){
//                sPtr--;
//                sBack--;
//            }
//            while(tBack>0 && tPtr>=0){
//                tPtr--;
//                tBack--;
//            }
//            if(sPtr<0 || tPtr<0){
//                if(sPtr==tPtr) return true;
//                else{
//                    System.out.println(sPtr +" "+ tPtr);
//                    return false;
//                }
//            }
//
//            if(S.charAt(sPtr)!=T.charAt(tPtr)){
//                System.out.println(S.charAt(sPtr)+" "+T.charAt(tPtr));
//                return false;
//            }else{
//                tPtr--;
//                sPtr--;
//            }
//        }
//        return true;
//    }
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
        String s = "ab##";
        String t = "c#d#";
        boolean res = B.backspaceCompareWithStack(s, t);
        System.out.println(res);
    }
}
