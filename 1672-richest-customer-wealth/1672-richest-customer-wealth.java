class Solution {
    public int maximumWealth(int[][] accounts) {
        int[] accs=new int[accounts.length];
        for(int i=0;i<accounts.length;i++){
            int sum=0;
            for(int num : accounts[i]){
                sum+=num;
            }
            accs[i]=sum;
        }
        int max = accs[0];
        for (int i = 1; i < accs.length; i++) {
            if (accs[i] > max) {
                max = accs[i];
            }
        }
        return max;
    }
}