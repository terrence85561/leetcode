package com.company.TwoPointer;
/*
  leetcode 125
  two pointer
 */
public class LC125_IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s==null) return true;
        int sLength = s.length();
        int l = 0, r = sLength - 1;
        while(r>=l){
            if(!Character.isLetterOrDigit(s.charAt(r))) r--;
            else if(!Character.isLetterOrDigit(s.charAt(l))) l++;
            else{
                if(!(Character.toLowerCase(s.charAt(l))==Character.toLowerCase(s.charAt(r)))) return false;
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC125_IsPalindrome p = new LC125_IsPalindrome();
        String s = "A an, a plan, a canal: Panama";
        boolean res = p.isPalindrome(s);
        System.out.println(res);
    }

}
