class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int

        leetcode: 3 lengthOfLongestSubstring
        """

        dict = {}
        begin = 0
        res = 0
        leng = len(s)
        for i in range (0,leng):
            if s[i] in dict:
                begin = max(begin,dict.get(s[i])+1)
            res = max(res,i - begin + 1)
            dict[s[i]] = i
        return res
