class Solution:
    def reverseWords(self, s: str) -> str:
        # O(N) time
        # O(N) space for storing the output string
        res = ""
        r = len(s)
        for i in range(len(s)-1, -1, -1):
            if s[i] == " ":
                r = i
            elif i == 0 or s[i-1] == " ":
                if len(res) != 0:
                    res += " "
                res += s[i:r]
        return res
