class Solution:
    def sumAndMultiply(self, n: int) -> int:
        str1=str(n)
        res=0
        num=0
        for i in str1:
            if i!='0':
                res+=int(i)
                num=num*10+int(i)
            
        return num*res       