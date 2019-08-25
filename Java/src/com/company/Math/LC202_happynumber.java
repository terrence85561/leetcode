package com.company.Math;

import java.util.HashSet;

public class LC202_happynumber {
    private int getSum(int n){
        int res = 0;
        while(n > 0){
            res = (n%10) * (n%10) + res;
            n = n / 10;
        }
        return res;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        slow = getSum(slow);
        fast = getSum(fast);
        fast = getSum(fast);
        while(slow != fast){
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
        }
        if(fast == 1) return true;
        else return false;
    }
    public boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            n = getSum(n);
        }
        if(n == 1) return true;
        else return false;
    }
}
