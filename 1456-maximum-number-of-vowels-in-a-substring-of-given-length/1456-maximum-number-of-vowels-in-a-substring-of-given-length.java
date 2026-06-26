class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count++;

            if (i >= k) {
                char left = s.charAt(i - k);
                if (left == 'a' || left == 'e' || left == 'i' || left == 'o' || left == 'u')
                    count--;

            }
            if (k==max){
                
            }

            max = Math.max(max, count);
        }

        return max;
    }
}