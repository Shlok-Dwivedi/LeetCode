void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int i = 0;
    int j = 0;
    int arr3[nums1Size + nums2Size];
    int index = 0;

    while (i < m && j < n) {
        if (nums1[i] <= nums2[j]) {
            arr3[index] = nums1[i];
            i++;
        } else {
            arr3[index] = nums2[j];
            j++;
        }
        index++;
    }

    while (i < m) {
        arr3[index] = nums1[i];
        index++;
        i++;
    }

    while (j < n) {
        arr3[index] = nums2[j];
        index++;
        j++;
    }

    for (i = 0; i < m + n; i++) {
        nums1[i] = arr3[i];
    }
}