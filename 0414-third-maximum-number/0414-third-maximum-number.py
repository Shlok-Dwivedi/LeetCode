class Solution(object):
    def thirdMax(self, nums):
        s = sorted(set(nums))

        if len(s) < 3:
            return s[-1]
        else:
            return s[-3]