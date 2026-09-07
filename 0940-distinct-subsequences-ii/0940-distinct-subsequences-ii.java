class Solution {
    public int distinctSubseqII(String s) {
        int mod=1000000007;
        int[] dp=new int[s.length()+1];

        dp[0]=1;

        int[] last=new int[26];

        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';

            dp[i+1]=(2*dp[i])%mod;

            dp[i+1]=(dp[i+1]-last[c]+mod)%mod;

            last[c]=dp[i];
        }

        return (dp[s.length()]-1+mod)%mod;
    }
}