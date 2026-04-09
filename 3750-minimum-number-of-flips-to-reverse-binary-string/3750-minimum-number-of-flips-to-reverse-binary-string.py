class Solution:
    def minimumFlips(self, n: int) -> int:
        binary = ""
        
        while n != 0:
            r = n % 2
            binary = str(r) + binary   # build correctly
            n //= 2
        
        rev = binary[::-1]
        
        flips = 0
        for i in range(len(binary)):
            if binary[i] != rev[i]:
                flips += 1
        
        return flips