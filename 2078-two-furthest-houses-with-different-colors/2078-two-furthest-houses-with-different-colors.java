class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int max_dist=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(colors[i]!=colors[j]){
                    max_dist=Math.max(max_dist,j-i);
                }
            }
        }

        return max_dist;
    }
}