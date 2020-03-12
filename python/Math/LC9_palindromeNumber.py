class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        if x > 0 and x % 10 == 0:
            return False
        a = x
        tmp = x % 10
        x //= 10
        while(x != 0):
            tmp *= 10
            tmp += x % 10
            x //= 10

        if tmp == a:
            return True
        return False
