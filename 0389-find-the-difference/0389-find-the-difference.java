class Solution {
    public char findTheDifference(String s, String t) {
        char[] charsOfS = s.toCharArray();
        Arrays.sort(charsOfS);

        char[] charsOfT = t.toCharArray();
        Arrays.sort(charsOfT);

        for (int i = 0; i < charsOfS.length; i++) {
            if (charsOfS[i] != charsOfT[i]) {
                return charsOfT[i];
            }
        }

        return charsOfT[charsOfT.length - 1];
    }
}