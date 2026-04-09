class Solution:
    def addDigits(self, num: int) -> int:
        if num<10:
            return num
        else:
            return self.addDigits(int(num/10)+(num%10))