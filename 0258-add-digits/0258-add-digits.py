class Solution:
    def addDigits(self, num: int) -> int:
        while(num>9):
            r=num%10
            num=int(num/10)
            num+=r
        return num