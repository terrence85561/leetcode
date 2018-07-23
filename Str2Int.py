import re
class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        import re
        text = "t 123"
    ptn = r"^ *\-*\d+"
    result = re.findall(ptn,text)
    print(result)





S = Solution()
str = "   -42"
output = S.myAtoi(str)
print(output)
