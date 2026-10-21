class Solution {
    public int sumofdigits(int n){
        int sum=0;
        while(n!=0){
            int r =n%10;
            sum=sum+r;
            n=n/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=sumofdigits(nums[i]);
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(mini>nums[i]){
                mini=nums[i];
            }
        }
        return mini;
    }
}