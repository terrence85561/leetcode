package com.company.Array;

import java.util.HashMap;
import java.util.Map;

public class LC560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        /*
            O(n)
            use hashmap to store the frequency of each prefix_sum
            key - prefix_sum
            value - frequency of this prefix_sum
            
         */
        int[] prefix_sum = new int[nums.length+1];
        int sum = 0;
        for(int i = 1; i < prefix_sum.length; i++){
            sum += nums[i-1];
            prefix_sum[i] = sum;
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : prefix_sum){
            res += map.getOrDefault(i - k, 0);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return res;
    }

    public int subarraySum1(int[] nums, int k) {
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
