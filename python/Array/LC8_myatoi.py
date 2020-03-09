class Solution:
    def myAtoi(self, s: str) -> int:
        n = len(s)
        l = 0
        while(l < n and s[l] == ' '):
            l += 1

        sign = 1
        if l < n and s[l] == '-':
            sign *= -1
            l += 1
        elif l < n and s[l] == '+':
            l += 1

        rtn = 0
        while(l < n and s[l].isdigit()):
            num = int(s[l])
            if(rtn > (2**31-1)//10 or (rtn == (2**31-1)//10and num >= 8)):
                if(sign == 1):
                    return 2**31 - 1
                else:
                    return -2**31
            l += 1
            rtn = rtn*10 + num

        return rtn*sign
