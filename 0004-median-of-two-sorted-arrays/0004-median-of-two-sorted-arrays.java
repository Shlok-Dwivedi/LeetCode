class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged=new int[nums1.length+nums2.length];
        int pos=0;
        for(int i=0;i<nums1.length;i++){
            merged[pos]=nums1[i];
            pos+=1;
        }

        for(int i=0;i<nums2.length;i++){
            merged[pos]=nums2[i];
            pos+=1;
        }

    int n = merged.length;
        for (int i = 1; i < n; ++i) {
            int key = merged[i];
            int j = i - 1;

            while (j >= 0 && merged[j] > key) {
                merged[j + 1] = merged[j];
                j = j - 1;
            }
            merged[j + 1] = key;
        }
        if (merged.length%2!=0){
            return merged[merged.length/2];
        }
        else{
            return ((float)(merged[merged.length/2]+merged[(merged.length/2)-1]))/2;
        }
    }
}