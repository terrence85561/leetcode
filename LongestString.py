class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        aList = []
        pt_1 = 0
        pt_2 = 0
        flag = 1
        answer = 1

        while flag:
            if len(s) == 0:
                flag =0
                answer =0
                break
            if s[pt_1] == s[pt_2]:
                if s[pt_1] not in aList:
                    aList.append(s[pt_1])
                pt_2 = pt_2 + 1
                if pt_2 == len(s):
                    flag = 0
                    break
            if s[pt_1] != s[pt_2]:
                if s[pt_1] not in aList:
                    aList.append(s[pt_1 ])
                pt_1 = pt_2 - 1
                if s[pt_2] in aList:
                    leng = len(aList)
                    if leng > answer:
                        answer = leng
                    aList.clear()
                    pt_1 = pt_2
                    pt_2 += 1
                else:
                    aList.append(s[pt_2])
                    pt_2 = pt_2 + 1
                    if pt_2 == len(s):
                        leng = len(aList)
                        if leng > answer:
                            answer = leng
            if pt_2 == len(s):
                flag = 0
                break
        return answer
S = Solution()
test = "aabcddddertyuiiiiiii"
output = S.lengthOfLongestSubstring(test)
print(output)
