package com.company;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        // leetcode 567 hash sliding window
        // corner case
        if(s1==null || s2==null || s1.length()==0 || s2.length()==0 || s1.length()>s2.length())return false;

        // create hash
        int[] hash = new int[26];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int s1Length = s1Arr.length;

        for(int i=0; i<s1Arr.length; i++){
            hash[s1Arr[i]-'a']++;
        }

        // sliding window
        int l = 0;
        int counter = 0;
        for(int i=0; i<s2Arr.length; i++){
            hash[s2Arr[i]-'a']--;
            if(hash[s2Arr[i]-'a']>=0){
                counter++;
            }
            if(i>=s1Length){
                hash[s2Arr[l]-'a']++;
                //check if this char is counted
                if(hash[s2Arr[l]-'a']>0){
                    counter--;
                }
                l++;
            }
            if(counter==s1Length)return true;
        }
        return false;

    }

    public static void main(String[] args) {
        CheckInclusion C = new CheckInclusion();
        String s1 = "abb";
        String s2 = "eidbacabbooo";
        System.out.println(C.checkInclusion(s1, s2));
    }
}
