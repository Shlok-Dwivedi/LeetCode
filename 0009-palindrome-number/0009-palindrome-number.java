class Solution {
    public boolean isPalindrome(int x) {
        // If the number is negative or ends with 0 (but is not 0), it is not a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 121;
        boolean result = solution.isPalindrome(x);
        System.out.println("Is Palindrome: " + result);
    }
}
