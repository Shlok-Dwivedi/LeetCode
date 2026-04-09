class Solution:
    def minMoves(self, nums: List[int]) -> int:
        max_num=max(nums)
        moves=0
        for i in nums:
            moves+=(max_num-i)
        return moves