/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 
int cmp(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int* majorityElement(int* nums, int numsSize, int* returnSize) {
    int num=numsSize/3;
    int* ret = (int*)malloc(sizeof(int) * numsSize);;
    qsort(nums, numsSize, sizeof(int), cmp);
    int ret_index=0;
    int count=1;
    int prev=nums[0]-17;
    for(int i=0;i<numsSize;i++){
        if (prev==nums[i]){
            count++;
        }
        if(prev!=nums[i]){
            prev=nums[i];
            count=1;
        }
        if (count>num){
            if(ret_index==0 ||ret[ret_index-1]!=nums[i]){
            ret[ret_index]=nums[i];
            ret_index++;
        }
        }
    }
    *returnSize=ret_index;
    return ret;
}