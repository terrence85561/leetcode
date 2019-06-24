package com.company.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    leetcode 15
    two pointer
    Time: n^2
    need sort first, but sort() only take nlogn, which is not affects time complexity n^2
 */
public class LC15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // corner case
        if(nums==null || nums.length == 0) return result;

        // sort input
        Arrays.sort(nums);
        int numLength = nums.length;

        int l,r;
        for(int i = 0; i < numLength; i++){
            if(i>=1 && nums[i]==nums[i-1]) continue;
            l = i+1;
            r = numLength-1;
            while(r>l){
                if(nums[i] + nums[r] + nums[l] > 0){
                    r--;
                }
                else if(nums[i] + nums[r] + nums[l] < 0){
                    l++;
                }
                else{
                    while(r>l && nums[r]==nums[r-1])r--;
                    while(r>l && nums[l]==nums[l+1])l++;
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;
                    l++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC15_ThreeSum T = new LC15_ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = T.threeSum(nums);
        System.out.println(res);
    }
}
