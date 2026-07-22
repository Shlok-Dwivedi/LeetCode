class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            char c=s.charAt(i);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                count++;
            }
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {
            char c=s.charAt(i);
            char d=s.charAt(i-k);
            if (d=='a' || d=='e' || d=='i' || d=='o' || d=='u') {
                count--;
            }
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u';
    }
}