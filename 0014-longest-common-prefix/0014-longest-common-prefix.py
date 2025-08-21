class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ""
        
        # Start with the first string as the prefix
        prefix = strs[0]
        
        # Compare the prefix with each string
        for s in strs[1:]:
            # Reduce the prefix until it matches the start of the string `s`
            while not s.startswith(prefix):
                prefix = prefix[:-1]
                if not prefix:
                    return ""
        
        return prefix

# Example usage
solution = Solution()

# Test cases
print(solution.longestCommonPrefix(["flower","flow","flight"])) # Output: "fl"
print(solution.longestCommonPrefix(["dog","racecar","car"]))    # Output: ""
print(solution.longestCommonPrefix(["interspecies","interstellar","interstate"])) # Output: "inters"
