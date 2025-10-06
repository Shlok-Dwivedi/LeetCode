int subsetXORSum(int* nums, int numsSize) {
    int orResult = 0;
    
    for (int i = 0; i < numsSize; i++) {
        orResult |= nums[i];
    }
    return orResult << (numsSize - 1);
}