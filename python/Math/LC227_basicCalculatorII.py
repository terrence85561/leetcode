class Solution:
    def getDigit(self, index, s):
        num = 0
        while(index < len(s)):
            if s[index].isdigit():
                num = num*10
                num += ord(s[index]) - ord('0')
                index+=1
            else:
                return index, num
        return index, num
    def calculate(self, s: str) -> int:
        sums = 0
        stack = []
        i = 0
        sign = 1
        isMul = False
        isDiv = False
        while(i<len(s)):
            if s[i] == ' ':
                i+=1
                continue
            elif s[i] == '+':
                sign = 1
            elif s[i] == '-':
                sign = -1
            elif s[i].isdigit():
                i, digt = self.getDigit(i, s)
                if isMul or isDiv:
                    last = stack.pop()
                    if isMul:
                        stack.append(last * digt)
                        isMul = False
                    else:
                        stack.append(last // digt)
                        isDiv = False
                else:
                    stack.append(sign)
                    stack.append(digt)
                i-=1
            elif s[i] == '*':
                isMul = True
            elif s[i] == '/':
                isDiv = True
            i+=1
        while(len(stack) != 0):
            sums+=stack.pop()*stack.pop()
        return sums
        