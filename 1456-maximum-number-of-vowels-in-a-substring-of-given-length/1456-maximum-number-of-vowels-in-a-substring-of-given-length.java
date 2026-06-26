class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int count = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) count++;

            if (i >= k && isVowel(arr[i - k])) count--;

            if (count > max) {
                max = count;
                if (max == k) return k;
            }
        }

        return max;
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}