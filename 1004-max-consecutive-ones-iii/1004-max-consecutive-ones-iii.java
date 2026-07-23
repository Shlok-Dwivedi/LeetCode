class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int zeroes=0;
        int max_ones=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            max_ones=Math.max(max_ones,right-left+1);
        }
        return max_ones;
    }
}