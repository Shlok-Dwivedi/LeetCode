class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int x1=x;
        int sum=0;
        while(x>0){
            int r=x%10;
            sum=sum*10+r;
            x=x/10;
        }
        if (x1==sum){
            return true;
        }
        return false;
    }
}