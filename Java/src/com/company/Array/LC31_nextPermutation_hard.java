package com.company.Array;

public class LC31_nextPermutation_hard {
    public void nextPermutation(int[] nums) {
        /*
         https://www.youtube.com/watch?v=quAS1iydq7U&t=524s
         O(n) time
         O(1) space

            从后往前遍历原始array，找到降序sufix-subarray前的index
            找到sufix-subarray中第一个比该index对应的element大的element，两者swap
            将sufix-subarray反转
        */

        int i = nums.length-2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }

        if(i >= 0){
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }

            swap(nums, i, j);

        }

        /*
            若该sufix-subarray从index 0开始，
            直接将整个array反转
        */

        reverse(nums, i+1);


    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        int hi = nums.length-1;
        int lo = start;
        while(lo <= hi){
            swap(nums, hi, lo);
            lo++;
            hi--;
        }
    }

}
