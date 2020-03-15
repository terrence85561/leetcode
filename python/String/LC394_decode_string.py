class Solution:
    #     def decodeString(self, s: str) -> str:
    #         cur = ''
    #         counts = []
    #         strs = []
    #         idx = 0
    #         while(idx < len(s)):
    #             if s[idx].isdigit():
    #                 num = 0
    #                 while(s[idx].isdigit()):
    #                     num *= 10
    #                     num += int(s[idx])
    #                     idx+=1
    #                 counts.append(num)
    #             elif s[idx] == '[':
    #                 strs.append(cur)
    #                 cur = ''
    #                 idx += 1

    #             elif s[idx] == ']':
    #                 num = counts.pop()
    #                 tmp = strs.pop()
    #                 for i in range(num):
    #                     tmp+=cur
    #                 cur = tmp
    #                 idx += 1

    #             else:
    #                 cur += s[idx]
    #                 idx+=1
    #         return cur
    def decodeString(self, s: str) -> str:
        cur = ''
        times = 0
        stack = []
        for i in s:
            if i.isdigit():
                times = times*10+int(i)
            elif i == '[':
                stack.append(cur)
                stack.append(times)
                cur = ''
                times = 0
            elif i == ']':
                num = stack.pop()
                prevString = stack.pop()

                for i in range(num):
                    prevString += cur

                cur = prevString
            else:
                cur += i
        return cur
