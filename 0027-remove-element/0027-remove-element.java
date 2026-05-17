class Solution {
    public int removeElement(int[] nums, int val) {
        int val_count=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==val){
                val_count++;
            }
        }
        int ptr=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[ptr]=nums[i];
                ptr++;
            }
        }
        return nums.length-val_count;
    }
}