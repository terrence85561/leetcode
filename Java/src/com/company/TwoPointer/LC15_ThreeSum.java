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
        if(nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;

        int l,r;
        for(int i = 0; i < size; i++){
            if(i >= 1 && nums[i] == nums[i-1]) continue;
            l = i + 1;
            r = size - 1;
            while(r > l){
                List<Integer> temp = new ArrayList<>();
                if(nums[i] + nums[r] + nums[l] < 0) l++;
                else if(nums[i] + nums[r] + nums[l] > 0) r--;
                else{
                    temp.add(nums[i]);
                    temp.add(nums[r]);
                    temp.add(nums[l]);
                    res.add(new ArrayList<>(temp));
                    while(r > l && nums[l] == nums[l+1]) l++;
                    while(r > l && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        LC15_ThreeSum T = new LC15_ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = T.threeSum(nums);
        System.out.println(res);
    }
}
