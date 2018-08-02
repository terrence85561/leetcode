class Solution {
  //leetcode: 516. Longest Palindromic Subsequence
    public int longestPalindromeSubseq(String s) {
        int strLength = s.length();
        if(s == null || strLength == 0){
            return 0;
        }
        int [][]dp = new int [strLength][strLength];
        for (int i = 0; i < strLength; i++){
            for(int j = 0; j < strLength; j++){
                dp[i][j] = 1;
            }
        }
        for(int i = 2; i <= strLength; i++ ){
            for(int j = 0;j <= strLength - i; j++){
                int k = i + j - 1;
                if (s.charAt(j) == s.charAt(k) && i == 2){
                    dp[j][k] =2;
                }else if (s.charAt(j) == s.charAt(k)){
                    dp[j][k] = dp[j+1][k-1]+2;
                }else{
                    dp[j][k] = Math.max(dp[j+1][k],dp[j][k-1]);
                }
            }
        }
        return dp[0][strLength - 1];

    }
}
