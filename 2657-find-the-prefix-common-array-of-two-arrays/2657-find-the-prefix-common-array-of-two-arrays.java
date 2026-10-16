class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        boolean[] seen = new boolean[n + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            seen[A[i]] = true;
            seen[B[i]] = true;

            for (int j = 1; j <= n; j++) {
                if (seen[j]) {
                    boolean inA = false, inB = false;

                    for (int k = 0; k <= i; k++) {
                        if (A[k] == j) inA = true;
                        if (B[k] == j) inB = true;
                    }

                    if (inA && inB) count++;
                }
            }

            C[i] = count;
            count = 0;
        }

        return C;
    }
}