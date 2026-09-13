class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        if(colors[0]!=colors[n-1])
            return n-1;

        int max_dist=0;
        for(int i=1;i<n;i++){
            if(colors[i]!=colors[0]){
                max_dist=Math.max(max_dist,i);
            }
        }
        for(int i=n-2;i>=0;i--){
            if(colors[i]!=colors[n-1]){
                max_dist=Math.max(max_dist,n-1-i);
            }
        }
        return max_dist;
    }
}