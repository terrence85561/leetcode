class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        flag = False
        if x < 0:
            return flag
        elif x < 10:
            flag = True
            return flag
        else:
            text = ''
            reverse = ''
            for i in str(x):
                text += i
            leng = len(text)
            for j in range(leng - 1, -1,-1):
                reverse += text[j]

            if text == reverse:
                flag = True
            return flag












S = Solution()
x = 122221
output = S.isPalindrome(x)
print(output)
