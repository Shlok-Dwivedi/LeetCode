class Solution {
    public void nextPermutation(int[] nums) {

        int a=-1,b=-1,ele_at_a=0;

        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                a=i-1;
                ele_at_a=nums[a];
                break;
            }
        }

        int n=nums.length;

        if(a!=-1){
            for(int i=nums.length-1;i>a;i--){
                if(nums[i]>ele_at_a){
                    b=i;

                    int temp=nums[a];
                    nums[a]=nums[b];
                    nums[b]=temp;

                    break;
                }
            }
        }

        for(int i=a+1,j=n-1;i<j;i++,j--){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}