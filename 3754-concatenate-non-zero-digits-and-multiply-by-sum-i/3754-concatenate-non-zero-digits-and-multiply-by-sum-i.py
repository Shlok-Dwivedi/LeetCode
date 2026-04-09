class Solution:
    def sumAndMultiply(self, n: int) -> int:
        n=str(n).replace("0","")
        s=0
        if n!="":
            for i in n:
                s+=int(i)
            return int(n)*s
        return 0