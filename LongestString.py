class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        dict = {} #for recording considering chars to determine repetition
        answer = 0 #for output
        pt1 = 0 #first pointer
        leng = len(s)#length of input

        #if input is empty
        if leng == 0:
            answer = 0
        else:
            #travers the whole input string use pt2
            #if any chars between pt1 and pt2 repeats,
            #pt1 move to the next char of the first repeated chars
            #length of the longest substring is pt2 - pt1
            for pt2 in range (0,leng):
                if s[pt2] in dict:

                    answer = max(answer,pt2 - pt1)
                    firstIndex = dict.get(s[pt2])
                    for j in range (pt1,firstIndex+1):
                        dict.pop(s[j])
                    pt1 = firstIndex + 1


                if s[pt2] not in dict:
                    dict[s[pt2]] = pt2
                if pt2 == leng - 1 and dict:
                    answer = max(len(dict),answer)
        return answer



S = Solution()
test = "aba"
output = S.lengthOfLongestSubstring(test)
print(output)
