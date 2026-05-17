class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean zero_present;
        int zero_count=0;
        int product=1;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==0){
                zero_count++;
            }
            else{
                product*=nums[i];
            }
        }
        if (zero_count==1){
            for(int i=0;i<nums.length;i++){
                if (nums[i]==0){
                    nums[i]=product;
                }
                else{
                    nums[i]=0;
                }
            }
        }

        else if (zero_count>1){
            for(int i=0;i<nums.length;i++){
                nums[i]=0;
            }
        }
        else{
            for(int i=0;i<nums.length;i++){
                nums[i]=product/nums[i];
            }
        }
        return nums;
    }
}