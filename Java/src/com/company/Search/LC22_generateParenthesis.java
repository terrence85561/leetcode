package com.company.Search;

import java.util.ArrayList;
import java.util.List;

public class LC22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        helper("", res, n, 0, 0);
        return res;
    }

    private void helper(String cur, List<String> res, int n, int right, int left){
        if(right > left){
            return;
        }
        if(right == n && left == n){
            res.add(new String(cur));
        }
        if(left < n){
            helper(cur + "(", res, n, right, left+1);
        }
        if(right < n){
            helper(cur + ")", res, n, right+1, left);
        }
    }
}
