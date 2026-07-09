class Solution {
    public String maskPII(String s) {
        boolean has_atrate=false;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='@'){
                has_atrate=true;
                break;
            }
        }
        if(has_atrate){
            int i=0;
            char c=s.charAt(i+1);
            while(c!='@'){
                i++;
                c=s.charAt(i+1);
            }
            sb.append(Character.toLowerCase(s.charAt(0)));
            sb.append("*****");
            for(int j=i;j<s.length();j++){
                sb.append(Character.toLowerCase(s.charAt(j)));
            }
        }
        else{
        StringBuilder digits = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    digits.append(c);
                }
            }
            int n = digits.length();
            if (n == 10) {
                sb.append("***-***-");
            } else {
                sb.append("+");
                for (int i = 0; i < n - 10; i++) {
                    sb.append("*");
                }
                sb.append("-***-***-");
            }
            for (int i = n - 4; i < n; i++) {
                sb.append(digits.charAt(i));
            }
        }
        return sb.toString();
    }
}