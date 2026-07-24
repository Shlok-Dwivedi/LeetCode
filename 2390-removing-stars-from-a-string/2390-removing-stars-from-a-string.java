class Solution {
    public String removeStars(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder str1=new StringBuilder();
        while(!(st.isEmpty())){
            str1.append(st.pop());
        }
        return str1.reverse().toString();
    }
}