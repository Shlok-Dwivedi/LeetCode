class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob_helper(nums,0,nums.length-2),rob_helper(nums,1,nums.length-1));
        
    }
    int rob_helper(int[] arr, int l, int r){
        int prev = 0;
        int prev2 = 0;
        for (int i = l; i <= r; i++) {
            int cur = Math.max(prev, prev2 + arr[i]);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}