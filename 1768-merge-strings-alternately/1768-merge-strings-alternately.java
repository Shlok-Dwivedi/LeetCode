class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str1=new StringBuilder();
        int index=Math.min(word1.length(),word2.length());
        for(int i=0;i<index;i++){
            str1.append(word1.charAt(i));
            str1.append(word2.charAt(i));
        }
        if(word1.length()<word2.length()){
            for(int i=index;i<word2.length();i++){
                str1.append(word2.charAt(i));
            }
        }
        else if(word2.length()<word1.length()){
            for(int i=index;i<word1.length();i++){
                str1.append(word1.charAt(i));
            }
        }
        return str1.toString();
    }
}