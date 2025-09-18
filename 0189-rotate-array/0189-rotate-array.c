#include <stdio.h>

// Helper function to reverse a portion of the array from start to end
void reverse(int* nums, int start, int end) {
    while (start < end) {
        // Swap elements
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        
        start++;
        end--;
    }
}

// Main function to rotate the array
void rotate(int* nums, int numsSize, int k) {
    // Handle cases where k is larger than the array size
    k %= numsSize;

    if (k == 0) {
        return;
    }

    // Step 1: Reverse the entire array
    reverse(nums, 0, numsSize - 1);
    
    // Step 2: Reverse the first k elements
    reverse(nums, 0, k - 1);
    
    // Step 3: Reverse the remaining elements
    reverse(nums, k, numsSize - 1);
}

// Utility function to print the array
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