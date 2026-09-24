class Solution {
    public int sum_of_digits(int n){
        int sum=0;
        while(n!=0){
            int r=n%10;
            sum=sum+r;
            n=n/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==sum_of_digits(nums[i])){
                return i;
            }
        }
        return -1;
    }
}