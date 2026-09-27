class Solution {
    int i=0;

    public String reverseParentheses(String s) {
        return solve(s);
    }

    String solve(String s) {
        StringBuilder str=new StringBuilder();

        while(i<s.length()) {
            char ch=s.charAt(i);

            if(ch=='(') {
                i++;
                String temp=solve(s);
                str.append(new StringBuilder(temp).reverse());
            }
            else if(ch==')') {
                i++;
                return str.toString();
            }
            else {
                str.append(ch);
                i++;
            }
        }

        return str.toString();
    }
}