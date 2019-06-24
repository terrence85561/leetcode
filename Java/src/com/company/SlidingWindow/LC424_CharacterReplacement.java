package com.company.SlidingWindow;
/*
    leetcode 424
    sliding window
    two ptrs
    右指针 - 左指针 + 1 - 重复最多的字母的个数 --> 需要替换的字母个数
 */
public class LC424_CharacterReplacement {
    public int characterReplacement(String s, int k) {

        char[] sArr = s.toCharArray();
        int sLength = sArr.length;

        // corner case
        if(s==null || sLength < k) return 0;

        // create hash
        int[] hash = new int[26];

        // sliding window
        int l = 0, maxCounter = 0, result = 0;
        for(int i = 0; i < sLength; i++){
            hash[sArr[i] - 'A']++;
            maxCounter = Math.max(maxCounter, hash[sArr[i] - 'A']);
            while(i > l && i - l + 1 - maxCounter > k){
                hash[sArr[l] - 'A']--;
                l++;
            }

            result = Math.max(result, i - l + 1);
        }
        return result;


    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        LC424_CharacterReplacement C = new LC424_CharacterReplacement();
        int res = C.characterReplacement(s, k);
        System.out.println(res);
    }
}

