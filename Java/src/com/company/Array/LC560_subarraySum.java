package com.company.Array;

public class LC560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        // O(n^2)
        /*

        int[] prefix_sum = new int[nums.length];
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefix_sum[i] = sum;
        }

        int res = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(i == 0){
                    if(prefix_sum[j] == k) res++;
                }else{
                    if (prefix_sum[j] - prefix_sum[i-1] == k){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    */
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int prefix_sum = 0;
            for(int j = i; j < nums.length; j++){
                prefix_sum += nums[j];
                if(prefix_sum == k) res++;
            }
        }
        return res;
    }
}
