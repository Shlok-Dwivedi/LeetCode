class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();

        Integer[] order=new Integer[n];
        for(int i=0;i<n;i++) order[i]=i;

        Arrays.sort(order,(a,b)->{
            int x=intervals.get(a).get(0);
            int y=intervals.get(b).get(0);
            if(x!=y) return Integer.compare(x,y);
            return Integer.compare(a,b);
        });

        int[] next=new int[n];

        for(int i=0;i<n;i++){
            int r=intervals.get(order[i]).get(1);

            int lo=i+1,hi=n;

            while(lo<hi){
                int mid=(lo+hi)/2;

                if(intervals.get(order[mid]).get(0)>r)
                    hi=mid;
                else
                    lo=mid+1;
            }

            next[i]=lo;
        }

        long[][] dp=new long[n+1][5];
        int[][][] path=new int[n+1][5][];

        for(int i=n-1;i>=0;i--){
            for(int c=0;c<=4;c++){

                // Don't take this interval
                dp[i][c]=dp[i+1][c];
                path[i][c]=path[i+1][c];

                // Take this interval
                if(c>0 && next[i]<=n){
                    long take=intervals.get(order[i]).get(2);

                    if(next[i]<n || c==1){
                        take+=dp[next[i]][c-1];

                        int[] p=new int[1+(path[next[i]][c-1]==null?0:path[next[i]][c-1].length)];

                        p[0]=order[i];

                        if(path[next[i]][c-1]!=null)
                            for(int x=0;x<path[next[i]][c-1].length;x++)
                                p[x+1]=path[next[i]][c-1][x];

                        Arrays.sort(p);

                        if(take>dp[i][c] ||
                           (take==dp[i][c] &&
                            (path[i][c]==null || 
                             Arrays.compare(p,path[i][c])<0))){
                            dp[i][c]=take;
                            path[i][c]=p;
                        }
                    }
                }
            }
        }

        long bestScore=0;
        int[] answer=new int[0];

        for(int c=1;c<=4;c++){
            if(dp[0][c]>bestScore ||
               (dp[0][c]==bestScore &&
                Arrays.compare(path[0][c],answer)<0)){
                bestScore=dp[0][c];
                answer=path[0][c];
            }
        }

        return answer;
    }
}