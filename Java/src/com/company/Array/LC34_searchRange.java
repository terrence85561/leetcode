package com.company.Array;

public class LC34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        /*
            binary seach
            
         */
        int min = -1;
        int max = -1;
        int[] res = {min, max};

        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] > target){
                hi = mid - 1;
            }else if(nums[mid] < target){
                lo = mid + 1;

            }else{
                hi = mid - 1;
                min = mid;
            }
        }
        if(min != -1 && nums[min] == target){
            res[0] = min;
        }else{
            return res;
        }

        lo = 0;
        hi = nums.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] > target){
                hi = mid - 1;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                lo = mid + 1;
                max = mid;
            }
        }
        if(max != -1 && nums[max] == target){
            res[1] = max;
            return res;
        }else{return res;}

    }
}
