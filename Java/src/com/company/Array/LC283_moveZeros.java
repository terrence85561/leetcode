package com.company.Array;

public class LC283_moveZeros {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for( int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(nums[zero] == 0){
                    nums[zero] = nums[i];
                    nums[i] = 0;
                }
                zero++; // ptr for zero moves together with i
            }
        }
    }


}
