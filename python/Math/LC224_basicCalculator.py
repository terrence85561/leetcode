class Solution:
    def getNext(self, index, s):
        num = 0
        while(index < len(s)):
            if s[index].isdigit():
                digt = ord(s[index]) - ord('0')
                num = num*10
                num+=digt
                index+=1
            else:
                return index, num
        return index, num
    def calculate(self, s: str) -> int:
        stack = []
        sums = 0
        sign = 1
        i = 0
        while(i < len(s)):
            if s[i] == ' ':
                i+=1
                continue
            elif s[i] == '-':
                sign = -1
            elif s[i] == '+':
                sign = 1
            elif s[i].isdigit():
                i,digt = self.getNext(i, s)
                i-=1
                sums += sign*digt
            elif s[i] == '(':
                stack.append(sums)
                stack.append(sign)
                sign = 1
                sums = 0
            elif s[i] == ')':
                sig = stack.pop()
                val = stack.pop()
                sums = sums*sig + val
            i+=1
        if len(stack) == 0:
            return sums
        return 0
            
            
        return sums