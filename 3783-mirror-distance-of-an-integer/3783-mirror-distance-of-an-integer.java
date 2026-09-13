class Solution {
    public int mirrorDistance(int n) {
        int a=n;
        int ret=0;
        while(a!=0){
            int r=a%10;
            ret=ret*10+r;
            a=a/10;
        }
        return Math.abs(n-ret);
    }
}