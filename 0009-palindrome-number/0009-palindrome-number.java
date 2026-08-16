class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int y=x;
        int n=0;
        while(y!=0){
            int r=y%10;
            n=n*10+r;
            y=y/10;
        }
        if (n==x){
            return true;
        }
        return false;
    }
}