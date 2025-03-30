class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        start = 0
        max_length = 0
        char_index = {}  # Map characters to their last indices

        for end in range(len(s)):
            if s[end] in char_index and char_index[s[end]] >= start:
                start = char_index[s[end]] + 1
            char_index[s[end]] = end
            max_length = max(max_length, end - start + 1)

        return max_length
solution=Solution()
s="abcabcbb"
res=solution.lengthOfLongestSubstring(s)
             