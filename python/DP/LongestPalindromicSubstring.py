class Solution:

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        leetcode : 5 longestPalindromeSubstring navie
        """

        aList = []
        resLength = 0
        strLength = len(s)
        if strLength == 0:
            return ""
        if strLength == 1:
            return s[0]

        for i in range (0,strLength):
            flag = False
            firstIdx = i
            for j in range (strLength-1,i,-1):
                secondIdx = j
                while(s[firstIdx] == s[secondIdx]):
                    if firstIdx + 1 == secondIdx or firstIdx == secondIdx:
                        firstIdx = i
                        if j - i + 1 > resLength:
                            resLength = j - i + 1
                            aList.clear()
                            aList.append(s[i:j+1])
                        flag = True
                        break
                    if s[firstIdx+1] == s[secondIdx-1]:
                        firstIdx += 1
                        secondIdx -= 1
                    if s[firstIdx + 1] != s[secondIdx-1]:
                        firstIdx = i
                        break
                if flag:
                    break

        if aList:
            return aList[0]
        else:
            return s[-1]



S = Solution()
input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
output = S.longestPalindrome(input)
print(output)
