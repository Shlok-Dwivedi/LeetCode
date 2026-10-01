class Solution {
    Stack<Character> st=new Stack<>();
    public boolean isValid(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }
            else if(!st.empty() && s.charAt(i)==')' && st.peek()=='('){
                st.pop();
            }
            else if(!st.empty() && s.charAt(i)==']' && st.peek()=='['){
                st.pop();
            }
            else if(!st.empty() && s.charAt(i)=='}' && st.peek()=='{'){
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.empty();
    }
}