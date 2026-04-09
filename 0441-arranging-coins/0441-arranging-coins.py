class Solution:
    def arrangeCoins(self, n: int) -> int:
        k = 1
        rows = 0
        
        while n >= k:
            n -= k
            rows += 1
            k += 1
        
        return rows