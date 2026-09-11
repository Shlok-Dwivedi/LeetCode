class Solution {
    public int totalNumbers(int[] digits) {
        int ans=0;
        for(int i=100;i<=999;i+=2){
            int num=i;
            int a=num%10;
            int b=(num/10)%10;
            int c=num/100;
            int[] count=new int[10];
            for(int d:digits)
                count[d]++;
            if(count[a]>0){
                count[a]--;

                if(count[b]>0){
                    count[b]--;

                    if(count[c]>0)
                        ans++;
                }
            }
        }
        return ans;
    }
}