class Solution {
    public int[] leftRightDifference(int[] nums) {
        int []left_array=new int[nums.length];
        int []right_array=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            left_array[i]=0;
            right_array[i]=0;
        }
        for(int i=1;i<nums.length;i++){
            left_array[i]=nums[i-1]+left_array[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            right_array[i]=nums[i+1]+right_array[i+1];
        }
        int []res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=Math.abs(left_array[i]-right_array[i]);
        }
        return res;
    }
}