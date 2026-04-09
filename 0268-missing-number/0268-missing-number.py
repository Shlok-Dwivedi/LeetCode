class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        v=[0]*(len(nums)+1)
        for i in nums:
            v[i]=1
        for i in range(len(v)):
            if v[i]==0:
                return i