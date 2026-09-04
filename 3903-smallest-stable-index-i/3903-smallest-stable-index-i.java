class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;

        int max_array[]=new int[n];
        int min_array[]=new int[n];

        max_array[0]=nums[0];

        for(int i=1;i<n;i++){
            max_array[i]=Math.max(max_array[i-1],nums[i]);
        }

        min_array[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            min_array[i]=Math.min(min_array[i+1],nums[i]);
        }

        for(int i=0;i<n;i++){
            if(max_array[i]-min_array[i]<=k){
                return i;
            }
        }

        return -1;
    }
}