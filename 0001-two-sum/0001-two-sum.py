class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n=len(nums)
        t=[]
        for i in range(n):
            for j in range(0,i+1):
                if i!=j:
                    if nums[i]+nums[j]==target:
                        t=[i,j]
        return t
solution=Solution()
nums=[2,7,11,15]
res=solution.twoSum(nums,9)