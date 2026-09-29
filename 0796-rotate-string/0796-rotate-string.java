class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
            return false;

        StringBuilder s1=new StringBuilder(goal);

        for(int j=0;j<goal.length();j++) {
            boolean same=true;

            for(int i=0;i<s.length();i++) {
                if(s1.charAt(i)!=s.charAt(i)) {
                    same=false;
                    break;
                }
            }

            if(same)
                return true;

            char c=s1.charAt(0);
            s1.deleteCharAt(0);
            s1.append(c);
        }

        return false;
    }
}