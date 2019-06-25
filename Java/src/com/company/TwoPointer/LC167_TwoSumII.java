package com.company.TwoPointer;

import java.util.ArrayList;

/*
    lc 167
    two ptrs

 */
public class LC167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length-1;
        while(r > l){
            long a = numbers[l], b = numbers[r];
            if(a + b > target) r--;
            else if(a + b < target) l++;
            else break;
        }

        res[0] = l + 1;
        res[1] = r + 1;

        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {2,5,7,15};
        int target = 9 ;
        LC167_TwoSumII T = new LC167_TwoSumII();
        int[] res = T.twoSum(numbers, target);
        System.out.println(res[0] + " " +  res[1]);
    }

}
