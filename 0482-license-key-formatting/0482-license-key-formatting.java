class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                total++;
            }
        }
        int firstGroup = total % k;
        if (firstGroup == 0) {
            firstGroup = k;
        }
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-') {
                continue;
            }
            ans.append(Character.toUpperCase(ch));
            count++;
            if (count == firstGroup && count != total) {
                ans.append('-');
            }
            else if (count > firstGroup &&
                    (count - firstGroup) % k == 0 &&
                    count != total) {
                ans.append('-');
            }
        }

        return ans.toString();
    }
}