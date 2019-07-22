package com.company.Array;

public class LC33_search {
    public int search(int[] nums, int target) {
        int size = nums.length;
        if(nums == null || size == 0) return -1;
        int lo = 0;
        int hi = size - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int mid_val = nums[mid];
            if(mid_val == target) return mid;
            else if(mid_val >= nums[lo]){
                if(target >= nums[lo] && target < mid_val ){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else if(mid_val < nums[lo]){
                if(target > mid_val && target <= nums[hi]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;

        LC33_search L = new LC33_search();
        int res = L.search(nums, target);
        System.out.println(res);
    }
}
