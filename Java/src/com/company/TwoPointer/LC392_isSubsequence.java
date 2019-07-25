package com.company.TwoPointer;

public class LC392_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        // greedy
        if(s.length() == 0) return true;
        if(s.length() > t.length()) return false;

        int t_ptr = 0;
        for(int i = 0; i < s.length(); i++){
            while(t_ptr < t.length() && t.charAt(t_ptr) != s.charAt(i)){
                t_ptr++;
            }
            if(t_ptr >= t.length()) return false;
            t_ptr++;
        }
        return true;

    }

    //     two ptrs
    //       public boolean isSubsequence(String s, String t) {
//         if(s.length() == 0) return true;
//         if(s == null || t == null || s.length() > t.length()) return false;

//         int counter = 0;
//         int s_ptr = 0;

//         for(int i = 0; i < t.length(); i++){
//             if(t.charAt(i) == s.charAt(s_ptr)){
//                 counter++;
//                 s_ptr++;
//             }
//             if(counter == s.length()) return true;
//         }
//         return false;
//     }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbbgdc";
        LC392_isSubsequence L = new LC392_isSubsequence();
        System.out.println(L.isSubsequence(s, t));
    }
}
