class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String lower = sb.toString().toLowerCase();
        int start = 0;
        int end = lower.length() - 1;
        while (start <= end) {
            if (lower.charAt(start) != lower.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}   