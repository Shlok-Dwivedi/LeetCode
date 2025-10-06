#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int* largestDivisibleSubset(int* nums, int numsSize, int* returnSize) {
    if (numsSize == 0) {
        *returnSize = 0;
        return NULL;
    }
    
    qsort(nums, numsSize, sizeof(int), compare);
    
    int* dp = (int*)malloc(numsSize * sizeof(int));
    int* parent = (int*)malloc(numsSize * sizeof(int));
    
    // Initialize
    for (int i = 0; i < numsSize; i++) {
        dp[i] = 1;
        parent[i] = -1;
    }
    
    int maxLen = 1;
    int maxIdx = 0;
    
    // Fill dp array
    for (int i = 1; i < numsSize; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] % nums[j] == 0) {
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }
        
        if (dp[i] > maxLen) {
            maxLen = dp[i];
            maxIdx = i;
        }
    }
    
    // Reconstruct the subset
    int* result = (int*)malloc(maxLen * sizeof(int));
    *returnSize = maxLen;
    
    int idx = maxIdx;
    for (int i = maxLen - 1; i >= 0; i--) {
        result[i] = nums[idx];
        idx = parent[idx];
    }
    
    free(dp);
    free(parent);
    
    return result;
}