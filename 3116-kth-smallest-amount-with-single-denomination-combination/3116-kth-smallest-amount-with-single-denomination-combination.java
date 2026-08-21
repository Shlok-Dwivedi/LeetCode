class Solution {
    public long findKthSmallest(int[] coins,int k) {
        long left=1;
        long right=(long)coins[0]*k;

        for(int coin:coins)
            right=Math.min(right,(long)coin*k);

        while(left<right){
            long mid=left+(right-left)/2;
            long count=0;

            for(int mask=1;mask<(1<<coins.length);mask++){
                long lcm=1;
                int bits=0;
                boolean valid=true;

                for(int i=0;i<coins.length;i++){
                    if((mask&(1<<i))!=0){
                        bits++;

                        long a=lcm;
                        long b=coins[i];

                        while(b!=0){
                            long temp=a%b;
                            a=b;
                            b=temp;
                        }

                        if(lcm/a>mid/coins[i]){
                            valid=false;
                            break;
                        }

                        lcm=lcm/a*coins[i];
                    }
                }

                if(valid && lcm<=mid){
                    if(bits%2==1)
                        count+=mid/lcm;
                    else
                        count-=mid/lcm;
                }
            }

            if(count>=k)
                right=mid;
            else
                left=mid+1;
        }

        return left;
    }
}