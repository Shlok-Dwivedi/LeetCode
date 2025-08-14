int searchInsert(int* nums, int numsSize, int target) {
    int k=0;
    for(int i=0;i<numsSize;i++){
        if(target<=nums[i]){
            k=i;
            break;
        }
    }
    if (target>nums[numsSize-1]){
        k=numsSize;
    }
    return k;
}