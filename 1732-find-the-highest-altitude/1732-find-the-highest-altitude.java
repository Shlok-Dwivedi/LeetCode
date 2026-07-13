class Solution {
    public int largestAltitude(int[] gain) {
        int[] t = new int[gain.length + 1];
        t[0] = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            t[i + 1] = t[i] + gain[i];
            max = Math.max(max, t[i + 1]);
        }

        return max;
    }
}