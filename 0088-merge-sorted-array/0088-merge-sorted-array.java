class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];

        int first = 0;
        int second = 0;
        int k = 0;

        while (first < m && second < n) {
            if (nums1[first] <= nums2[second]) {
                ans[k++] = nums1[first++];
            } else {
                ans[k++] = nums2[second++];
            }
        }

        while (first < m) {
            ans[k++] = nums1[first++];
        }

        while (second < n) {
            ans[k++] = nums2[second++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    }
}