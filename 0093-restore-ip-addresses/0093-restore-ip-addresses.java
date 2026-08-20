class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        int n=s.length();

        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                for(int k=1;k<=3;k++){
                    int l=n-i-j-k;

                    if(l<1 || l>3)
                        continue;

                    String a=s.substring(0,i);
                    String b=s.substring(i,i+j);
                    String c=s.substring(i+j,i+j+k);
                    String d=s.substring(i+j+k);

                    if((a.length()>1 && a.charAt(0)=='0') ||
                       (b.length()>1 && b.charAt(0)=='0') ||
                       (c.length()>1 && c.charAt(0)=='0') ||
                       (d.length()>1 && d.charAt(0)=='0'))
                        continue;

                    if(Integer.parseInt(a)<=255 &&
                       Integer.parseInt(b)<=255 &&
                       Integer.parseInt(c)<=255 &&
                       Integer.parseInt(d)<=255){

                        ans.add(a+"."+b+"."+c+"."+d);
                    }
                }
            }
        }

        return ans;
    }
}