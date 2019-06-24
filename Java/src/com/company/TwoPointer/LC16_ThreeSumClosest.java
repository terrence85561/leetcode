package com.company.TwoPointer;

import java.util.Arrays;

/*
    lc 16
    two ptrs
 */
public class LC16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        int numsLength = nums.length;

        for(int i = 0; i < numsLength; i++){
            int l = i+1, r = numsLength-1;
            while(r>l){
                if(Math.abs(nums[i]+nums[l]+nums[r]-target) < diff){
                    diff = Math.abs(nums[i]+nums[l]+nums[r]-target);
                    result = nums[i]+nums[l]+nums[r];
                }
                if(nums[i]+nums[l]+nums[r] < target) l++;
                else if(nums[i]+nums[l]+nums[r] > target) r--;
                else if(nums[i]+nums[l]+nums[r] == target) return target;

            }
        }
        return result;
    }





    public static void main(String[] args) {
        LC16_ThreeSumClosest T = new LC16_ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        int target = -20 ;
        int res = T.threeSumClosest(nums, target);
        System.out.println(res);
    }
}
