/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let start = 0;
    let maxLength = 0;
    let charIndex = new Map(); // Stores the last seen index of characters

    for (let end = 0; end < s.length; end++) {
        const currentChar = s[end];
        if (charIndex.has(currentChar) && charIndex.get(currentChar) >= start) {
            start = charIndex.get(currentChar) + 1;
        }
        charIndex.set(currentChar, end);
        maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
};