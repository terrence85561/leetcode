package com.company.Array;

public class LC4_findMedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
            time : O(n+M)
        */
        int size1 = nums1.length;
        int size2 = nums2.length;

        int[] temp = new int[size1 + size2];
        int temp_size = size1 + size2;
        int idx = 0;

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < size1 && idx2 < size2){
            if(nums1[idx1] <= nums2[idx2]){
                temp[idx] = nums1[idx1];
                idx1++;
            }else{
                temp[idx] = nums2[idx2];
                idx2++;
            }
            idx++;
        }

        while(idx1 < size1){
            temp[idx++] = nums1[idx1];
            idx1++;
        }

        while(idx2 < size2){
            temp[idx++] = nums2[idx2];
            idx2++;
        }

        int total_size = size1+size2;
        if(total_size % 2 == 0){
            return (double) (temp[total_size / 2] + temp[(total_size / 2) - 1]) / 2;
        }else{
            return (double) temp[total_size / 2];
        }

    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        /*
            O(log(min(m,n))
         */
        if(nums1.length > nums2.length) return findMedianSortedArrays1(nums2, nums1);

        int size1 = nums1.length;
        int size2 = nums2.length;

        int lo = 0;
        int hi = size1;
        // [ 1 2 3 4 ]
        // [ 5 6 7 8 9]
        while(lo <= hi){
            int partition1 = lo + (hi - lo) / 2;
            int partition2 = (size1+size2+1) / 2 - partition1;

            int max_part1_left = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1-1];
            int min_part1_right = (partition1 == size1) ? Integer.MAX_VALUE : nums1[partition1];

            int max_part2_left = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2-1];
            int min_part2_right = (partition2 == size2) ? Integer.MAX_VALUE : nums2[partition2];

            if(max_part1_left <= min_part2_right && max_part2_left <= min_part1_right){
                if((size1+size2) % 2 == 0){
                    return ((double) Math.max(max_part1_left, max_part2_left) + Math.min(min_part1_right, min_part2_right)) / 2 ;
                }else{
                    return (double) Math.max(max_part1_left, max_part2_left);
                }
            }else if(max_part1_left > min_part2_right){
                hi = partition1-1;
            }else{
                lo = partition1+1;
            }
        }

        return -1;
    }
}
