class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        leetcode : 9 palindrome number
        O(log(n))
        """


        if x < 0 or (x % 10 == 0 and x != 0):
            return False


        else:
            reverseInt = 0
            # it's even
            # 1221 % 10 = 1, 0*10 + 1 = 1
            # 1221 // 10 = 122
            # 122 % 10 = 2, 1 * 10 + 2 = 12
            # 122 // 10 = 12
            # reach half of int x, return
            # it's odd
            # 12221 % 10 = 1, 0 * 10 + 1 = 1
            # 12221 // 10 = 1222
            # 1222 % 10 = 2, 1*10 + 2 = 12
            # 1222 // 10 = 122
            # 122 % 10 = 2, 12 * 10 + 2 = 122
            # 122 // 10 = 12
            # reach half, return

            while(x > reverseInt):
                last = x % 10
                reverseInt = last + reverseInt * 10
                x = x // 10
            return x == reverseInt or reverseInt // 10 == x





            # text = ''
            # reverse = ''
            # for i in str(x):
            #     text += i
            # leng = len(text)
            # for j in range(leng - 1, -1,-1):
            #     reverse += text[j]
            #
            # if text == reverse:
            #     flag = True
            # return flag












S = Solution()
x = 0
output = S.isPalindrome(x)
print(output)
