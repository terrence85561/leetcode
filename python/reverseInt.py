class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        leetcode : 7 reverse int
        """
        result = 0
        flag = False
        if x == 0:
            return x
        elif x < 0:
            x = -x
            flag = True

        while(x > 0):
            lastDig = x - x//10 * 10
            result = result * 10 + lastDig
            x = x//10
        if flag:
            result = -result

        if result <= 2147483647 and result >= -2147483648:
            return result
        else:
            return 0







S = Solution()
input = 123
output = S.reverse(input)
print(output)
