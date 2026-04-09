class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        numbers = []
        fact = 1
        
        for i in range(1, n + 1):
            fact *= i
            numbers.append(i)
        
        fact //= n
        k -= 1  # convert to 0-based
        
        result = []
        
        while True:
            index = k // fact
            result.append(str(numbers[index]))
            numbers.pop(index)
            
            if not numbers:
                break
            
            k %= fact
            fact //= len(numbers)
        
        return ''.join(result)