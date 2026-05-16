class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int max_index=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]>max){
                max=nums[i];
                max_index=i;
            }
        }
        int second_max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if (nums[i]>second_max && i!=max_index ){
                second_max=nums[i];
            }
        }
        return ((max-1)*(second_max-1));
    }
}