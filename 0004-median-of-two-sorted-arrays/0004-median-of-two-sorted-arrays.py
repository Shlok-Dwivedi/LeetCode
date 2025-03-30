class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums1.extend(nums2)
        nums1.sort()
        
        n = len(nums1)
        
        if n % 2 == 1:
            median = nums1[n // 2]
        else:
            mid1 = n // 2
            mid2 = mid1 - 1
            median = (nums1[mid1] + nums1[mid2]) / 2.0
        
        return median

solution = Solution()
nums1 = [1, 2]
nums2 = [3, 4]
res = solution.findMedianSortedArrays(nums1, nums2)
print(res)
