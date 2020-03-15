class Solution:
    def reverseWords(self, s: List[str]) -> None:
        #O(N) time
        #O(1) space
        # first loop reverse the whole list
        # second loop reverse each word
        """
        Do not return anything, modify s in-place instead.
        """
        self.reverse(s, 0, len(s)-1)
        l = 0
        for i in range(len(s)):
            if s[i] == " ":
                self.reverse(s, l, i-1)
                l = i+1
            elif i == len(s)-1:
                self.reverse(s, l, i)

    def reverse(self, s, l, r):
        while(l <= r):
            temp = s[l]
            s[l] = s[r]
            s[r] = temp
            l += 1
            r -= 1
