package com.company.TwoPointer;
/*
    lc 11
    two ptrs
    array
    Time : O(n)
 */
public class LC11_MaxArea {
    public int maxArea(int[] height) {
        int result = 0;
        int hLength = height.length;
        int l = 0, r = hLength-1;
        while(r>l){
            int area = (r-l)*Math.min(height[r],height[l]);
            result = Math.max(result, area);
            if(height[l]>height[r]) r--;
            else l++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        LC11_MaxArea M = new LC11_MaxArea();
        int res = M.maxArea(height);
        System.out.println(res);
    }

}
