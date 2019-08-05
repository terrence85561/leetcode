package com.company.DynamicProgramming;

public class LC152_maxProduct {
    public int maxProduct(int[] nums) {
        int max_to_cur = nums[0];
        int min_to_cur = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp_max = max_to_cur;
            int temp_min = min_to_cur;
            max_to_cur = Math.max(max_to_cur*nums[i], Math.max(nums[i], min_to_cur*nums[i]));
            min_to_cur = Math.min(min_to_cur*nums[i], Math.min(nums[i], temp_max*nums[i]));
            if(max_to_cur > max) max = max_to_cur;
        }
        return max;
    }
}
