/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    if (numsSize<2){
        return NULL;
    }
    int* original_nums = malloc(numsSize * sizeof(int));
    memcpy(original_nums, nums, numsSize * sizeof(int));

    for(int i=0;i<numsSize-1;i++){
        for (int j=0;j<numsSize-i-1;j++){
            if (nums[j]>nums[j+1]){
                int temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
            }
        }
    }

    int forward_index=0;
    int backward_index=numsSize-1;

    while(forward_index<backward_index){
        if (nums[forward_index]+nums[backward_index]>target){
            backward_index-=1;
        }
        else if (nums[forward_index]+nums[backward_index]<target){
            forward_index+=1;
        }

        else if (nums[forward_index]+nums[backward_index]==target){
            int* result = malloc(2 * sizeof(int));
            *returnSize=2;
            result[0]=forward_index;
            result[1]=backward_index;
            int index1=-1;

             for (int i = 0; i < numsSize; i++) {
                if (original_nums[i] == nums[forward_index] && index1 == -1) {
                    result[0] = i;
                    index1 = i;
                } else if (original_nums[i] == nums[backward_index]) {
                    result[1] = i;
                }
            }
            free(original_nums);
            *returnSize = 2;


            return result;
        }
    }
    *returnSize = 0;
    return NULL;
}