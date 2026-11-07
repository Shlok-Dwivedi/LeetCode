class Solution {
    public int[] productExceptSelf(int[] nums) {
        int num_zeroes=0;
        int product=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                num_zeroes+=1;
                if(num_zeroes>1){
                    break;
                }
            }
            else{
                product=product*nums[i];
            }
        }
        int []res=new int[nums.length];
        if(num_zeroes==0){
            for(int i=0;i<nums.length;i++){
                res[i]=product/nums[i];
            }
        }
        else if(num_zeroes==1){
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    res[i]=0;
                }
                else{
                    res[i]=product;
            }
        }
        }
        else{
            for(int i=0;i<nums.length;i++){
                res[i]=0;
            }
        }
        return res;
    }
}