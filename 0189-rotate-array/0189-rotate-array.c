#include <stdio.h>
void reverse(int* nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        
        start++;
        end--;
    }
}

void rotate(int* nums, int numsSize, int k) {
    k %= numsSize;

    if (k == 0) {
        return;
    }
    reverse(nums, 0, numsSize - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, numsSize - 1);
}

void printArray(int* nums, int size) {
    printf("[");
    for (int i = 0; i < size; i++) {
        printf("%d", nums[i]);
        if (i < size - 1) {
            printf(",");
        }
    }
    printf("]\n");
}