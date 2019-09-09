package com.company.BinarySearch;

public class LC74_searchMatrix {
    public boolean searchMatrix(int[][] m, int t) {
        if(m == null) return false;
        if(m.length == 0 || m[0].length == 0) return false;
        int m_num_row = m.length;
        int m_num_col = m[0].length;

        int lo = 0;
        int hi = m_num_row - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(t < m[mid][0]){
                if(mid == 0) return false;
                hi = mid - 1;
            }else if(t > m[mid][m_num_col-1]){
                lo = mid + 1;
            }else{
                lo = 0;
                hi = m[mid].length;
                while(lo <= hi){
                    int md = lo + (hi - lo)/2;
                    if(t < m[mid][md]){
                        hi = md - 1;
                    }else if(t > m[mid][md]){
                        lo = md + 1;
                    }else{
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
