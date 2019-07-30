package com.company.DynamicProgramming;

public class LC53_maxSubArray {
    public int maxSubArray(int[] nums) {
//     dp solution, not really understand
//        if(nums == null || nums.length == 0) return 0;
//
//        // init
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//
//        int max = nums[0];
//
//        // transition
//        for(int i = 1; i < n; i++){
//            dp[i] = nums[i] + (dp[i-1]>0?dp[i-1]:0);
//            max = Math.max(dp[i], max);
//        }
//
//        return max;

        int max_to_cur = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max_to_cur = Math.max(nums[i], nums[i]+ max_to_cur);
            max = Math.max(max_to_cur, max);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        LC53_maxSubArray L = new LC53_maxSubArray();
        System.out.println(L.maxSubArray(nums));
    }
}
