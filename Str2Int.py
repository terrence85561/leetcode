import re
class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        leetcode: 8
        """
        text = ''
        ptn = r"^ *[\+\-]?\d+"
        result = re.findall(ptn,str)
        if result:
            for i in result:
                if i != ' ':
                    text = text + i

            output = int(text)
        else:
            return 0
        if output < -2147483648:
            output = -2147483648
        elif output > 2147483647:
            output = 2147483647
        return output







S = Solution()
str = " -+2"
output = S.myAtoi(str)
print(output)
