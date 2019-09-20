package com.company.Math;

import java.util.LinkedList;
import java.util.List;

public class LC43_multiply {
    public String multiply(String num1, String num2) {
        int num1_length = num1.length();
        int num2_length = num2.length();
        int[] res = new int[num1_length+num2_length];
        for(int i = num2_length-1; i >= 0; i--){
            for(int j = num1_length-1; j >= 0; j--){
                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                mul += res[i+j+1];
                res[i+j+1] = mul%10;
                res[i+j] += mul/10;
            }
        }

        List<Character> list = new LinkedList<>();
        for(int i = 0; i < res.length; i++){
            if(list.size() == 0 && res[i] == 0){
                continue;
            }else{
                list.add((char)(res[i]+48));
            }
        }
        if(list.size()==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : list){
            sb.append(c);
        }
        return sb.toString();
    }
}
