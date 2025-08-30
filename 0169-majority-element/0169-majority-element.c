int majorityElement(int* nums, int numsSize) {
    int len=numsSize/2;
    int count[numsSize][2];
    int index=0;
    for(int i=0;i<numsSize;i++){
        int found = 0;
    for (int j = 0; j < index; j++) {
        if (count[j][0] == nums[i]) {
            count[j][1]++;
            found = 1;
            break;   // stop checking once found
        }
    }
    if (!found) {
        count[index][0] = nums[i];
        count[index][1] = 1;
        index++;
    }

    }
    int max_index=0;
    int max_count=0;
    for(int i=0;i<index;i++){
        if(count[i][1]>max_count){
            max_count=count[i][1];
            max_index=i;
        }
    }
    return count[max_index][0];
}