class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Define the Roman numeral values
        roman_values = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        
        # Initialize the total
        total = 0
        
        # Iterate through the string, converting each symbol
        for i in range(len(s)):
            # If the current value is less than the next value, subtract it
            if i < len(s) - 1 and roman_values[s[i]] < roman_values[s[i + 1]]:
                total -= roman_values[s[i]]
            else:
                # Otherwise, add it
                total += roman_values[s[i]]
        
        return total

# Example usage
solution = Solution()

# Convert Roman numerals to integers
print(solution.romanToInt("III"))