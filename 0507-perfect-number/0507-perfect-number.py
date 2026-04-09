class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num <= 1:
            return False
        
        divs = []
        
        for i in range(1, int(num**0.5) + 1):
            if num % i == 0:
                divs.append(i)
                
                if i != num // i:
                    divs.append(num // i)
        
        divs.remove(num)
        
        return sum(divs) == num