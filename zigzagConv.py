class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        count = 2*numRows-2
        counter = count
        result = []
        leng = len(s)

        
        if leng <= numRows or not s or numRows == 1:
            return s
        for i in range(0,numRows):
            pos = i
            if counter == count or counter == 0:
                while(pos<leng):
                    result.append(s[pos])
                    pos += count
                if counter == count:
                    counter -=2
                    continue
            else:
                temp = counter
                while(pos<leng):
                    result.append(s[pos])
                    pos = pos+temp
                    temp = count - temp
                counter -= 2
                continue
        text = ''.join(result)
        return text




S = Solution()
input = "AB"

numRows = 1
output = S.convert(input,numRows)
print(output)
