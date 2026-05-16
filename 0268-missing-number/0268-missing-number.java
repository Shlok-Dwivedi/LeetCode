class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int all_sum=0;
        while(n>0){
            all_sum+=n;
            n--;
        }
        for(int i=0;i<nums.length;i++){
            all_sum-=nums[i];
            
        }
        return all_sum;
    }
}