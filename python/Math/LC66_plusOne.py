class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 0
        for i in range(len(digits)-1, -1, -1):
            d = digits[i]
            if i == len(digits)-1:
                d = d+1+carry
            else:
                d += carry
            digits[i] = d % 10
            carry = d//10
        if carry != 0:
            digits = [carry] + digits
        return digits
