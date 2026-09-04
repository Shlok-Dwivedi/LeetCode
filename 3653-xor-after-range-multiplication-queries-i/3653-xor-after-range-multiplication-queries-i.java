class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod = 1000000007;
        
        for(int[] q : queries){
            int l=q[0];
            int r=q[1];
            int k=q[2];
            int v=q[3];

            for(int i=l;i<=r;i+=k){
                nums[i]=(int)((nums[i]*(long)v)%mod);
            }
        }

        int ans=0;

        for(int num:nums){
            ans^=num;
        }

        return ans;
    }
}