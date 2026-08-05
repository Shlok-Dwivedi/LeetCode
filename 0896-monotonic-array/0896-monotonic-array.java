class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length<=2){
            return true;
        }

        boolean is_increasing=check_monotonicity(nums);

        if(is_increasing){
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    return false;
                }
            }
        }
        else{
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]<nums[i+1]){
                    return false;
                }
            }
        }
        return true;
    }

    boolean check_monotonicity(int[] nums){
        int index=0;

        while(index<nums.length-1 && nums[index]==nums[index+1]){
            index++;
        }

        if(index==nums.length-1){
            return true;
        }

        if(nums[index]<nums[index+1]){
            return true;
        }
        else{
            return false;
        }
    }
}