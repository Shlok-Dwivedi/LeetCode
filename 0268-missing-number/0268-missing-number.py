class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        d={}
        for i in range(len(nums)+1):
            d[i]=0
        for i in nums:
            d[i]=1
        for i in d:
            if d[i]==0:
                return i