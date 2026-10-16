import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        TreeSet<Integer> seenA = new TreeSet<>();
        TreeSet<Integer> seenB = new TreeSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            seenA.add(A[i]);
            seenB.add(B[i]);

            for (int x : seenA) {
                if (seenB.contains(x)) {
                    count++;
                }
            }

            C[i] = count;
            count = 0;
        }

        return C;
    }
}