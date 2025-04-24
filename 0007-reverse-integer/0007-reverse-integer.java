class Solution {
    public int reverse(int x) {
        long rev_x = 0;  // Use long to handle overflow temporarily
        int sign = x < 0 ? -1 : 1;  // Save the sign of x
        x = Math.abs(x);  // Work with the absolute value of x

        while (x != 0) {
            rev_x = rev_x * 10 + x % 10;  // Append the last digit of x to rev_x
            x /= 10;  // Remove the last digit from x
        }

        rev_x *= sign;  // Reapply the original sign to the reversed number

        if (rev_x < Integer.MIN_VALUE || rev_x > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) rev_x;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = -123;
        int result = solution.reverse(x);
        System.out.println("Reversed Integer: " + result);
    }
}
