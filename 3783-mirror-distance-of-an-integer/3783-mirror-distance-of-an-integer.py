class Solution:
    def mirrorDistance(self, n: int) -> int:
        num2=str(n)
        num2=num2[::-1]
        num_rev=int(num2)
        return abs(n-num_rev)