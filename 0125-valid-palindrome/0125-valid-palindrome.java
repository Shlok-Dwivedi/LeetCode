class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char c1 = Character.toLowerCase(s.charAt(start));
            char c2 = Character.toLowerCase(s.charAt(end));

            if (!((c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1 <= '9'))) {
                start++;
                continue;
            }

            if (!((c2 >= 'a' && c2 <= 'z') || (c2 >= '0' && c2 <= '9'))) {
                end--;
                continue;
            }

            if (c1 != c2) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}