class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<3){
            return true;
        }
        Arrays.sort(arr);
        int diff=Integer.MIN_VALUE;;
        for(int i=0;i<arr.length-1;i++){
            if (i==0){
                diff=arr[i+1]-arr[i];
            }
            else{
                if(arr[i+1]-arr[i]!=diff){
                    return false;
                }
            }
        }
        return true;
    }
}