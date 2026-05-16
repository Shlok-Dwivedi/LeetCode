class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            int rem=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if (nums[j]==rem){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}