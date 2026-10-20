class Solution {
    public int numberOfSpecialChars(String word) {
        int lower = 0, upper = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c))
                lower |= 1 << (c - 'a');
            else
                upper |= 1 << (c - 'A');
        }
        return Integer.bitCount(lower & upper);
    }
}   